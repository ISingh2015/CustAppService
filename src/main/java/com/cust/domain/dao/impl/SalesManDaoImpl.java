package com.cust.domain.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cust.common.ApplicationException;
import com.cust.common.Pagination;
import com.cust.common.QueryCriteria;
import com.cust.common.QueryUtility;
import com.cust.common.ServiceControl;
import com.cust.domain.dao.SalesManDao;
import com.cust.domain.vo.ElegantSalesMan;
import com.cust.util.ElegantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author Inderjit
 */
public class SalesManDaoImpl extends HibernateDaoSupport implements SalesManDao, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(SalesManDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ElegantSalesMan getSalesManById(long compId, long salesManId) throws ApplicationException {
        ElegantSalesMan elegantSalesMan = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getSalesManById");
            query.setParameter(0, compId);
            query.setParameter(1, salesManId);
            if (!query.list().isEmpty()) {
                elegantSalesMan = (ElegantSalesMan) query.list().get(0);
            }
            if (logger.isDebugEnabled()) logger.debug("getSalesManById " + compId + " - " + salesManId);
        } catch (Exception e) {
            logger.error("Error getSalesManById() " + e.getMessage());
            throw new ApplicationException("Error getSalesManById() "
                    + e.getMessage());
        }
        return elegantSalesMan;

    }

    @Override
    public ArrayList<ElegantSalesMan> getAllSalesMan(ServiceControl serviceControl, long compId)
            throws ApplicationException {
        ArrayList<ElegantSalesMan> elegantSalesManList = null;
        Pagination pagination = serviceControl.getPagination();
        QueryCriteria queryCriteria;

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getAllSalesMan");
            String queryString = query.getQueryString();

            queryCriteria = serviceControl.getQueryCriteria();
            queryString += QueryUtility.getQueryCriteriaString(queryCriteria,
                    sessionFactory, new ElegantSalesMan());
            query = session.createSQLQuery(queryString).addEntity(
                    ElegantSalesMan.class);
            if (pagination != null) {
                int firstPage = (int) ((pagination.getCurrrentPageNumber() - 1) * pagination
                        .getMaxPageSize());
                query.setFirstResult(firstPage);
                query.setMaxResults((int) pagination.getMaxPageSize());
            }
            query.setParameter(0, compId);
            elegantSalesManList = (ArrayList<ElegantSalesMan>) query.list();
            if (logger.isDebugEnabled()) logger.debug("getAllSalesMan " + compId);
        } catch (Exception e) {
            logger.error("Error getAllSalesMan() " + e.getMessage());
            throw new ApplicationException("Error getAllSalesMan() "
                    + e.getMessage());
        }
        return elegantSalesManList;
    }

    @Override
    public ArrayList<ElegantSalesMan> saveSalesManList(ArrayList<ElegantSalesMan> salesManList)
            throws ApplicationException {
        long key = 0;
        boolean updated = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantSalesMan salesMan : salesManList) {
                if (salesMan.getUserID() == 0) {
                    throw new ApplicationException("saveSalesManList: -> UserId cannot be Zero");
                }
                if (salesMan.getSalesManID() == 0) {
                    key = getMaxSalesManKey(salesMan.getCompID());
                    salesMan.setSalesManID(key);
                }
                session.saveOrUpdate(salesMan);
                updated = true;
            }
            if (updated) {
                session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[1]));
                if (logger.isDebugEnabled()) logger.debug("saveSalesManList " + salesManList.size());
            }
        } catch (Exception e) {
            logger.error("Error saveSalesManList() " + e.getMessage());
            throw new ApplicationException("Error saveSalesManList() "
                    + e.getMessage());

        }
        return salesManList;

    }

    private long getMaxSalesManKey(long compId) throws ApplicationException {

        Long salesManId = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxSalesManKey");
            query.setParameter(0, compId);
            salesManId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxSalesManKey() " + e.getMessage());
            throw new ApplicationException("getMaxSalesManKey() " + e.getMessage());
        }
        return salesManId;
    }

    @Override
    public Boolean deleteSalesManList(ArrayList<ElegantSalesMan> salesManList)
            throws ApplicationException {
        int countDeleted = 0, elementsDeleted = 0;
        boolean deleted = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantSalesMan salesMan : salesManList) {
                Query query = session.getNamedQuery("deleteSalesMan");
                query.setParameter(0, salesMan.getCompID());
                query.setParameter(1, salesMan.getSalesManID());
                countDeleted = query.executeUpdate();
                if (countDeleted > 0) {
                    elementsDeleted++;
                    deleted = true;
                }
            }
            if (deleted) {
                session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[1]));
                if (logger.isDebugEnabled()) logger.debug("deleteSalesManList " + salesManList.size());
            }
        } catch (Exception e) {
            logger.error("deleteSalesManList() " + e.getMessage());
            throw new ApplicationException("deleteSalesManList() " + e.getMessage());
        }

        return elementsDeleted == salesManList.size();
    }

}
