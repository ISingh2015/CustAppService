package com.cust.domain.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.cust.common.ApplicationException;
import com.cust.common.Pagination;
import com.cust.common.QueryCriteria;
import com.cust.common.QueryUtility;
import com.cust.common.ServiceControl;
import com.cust.domain.dao.SupplierDao;
import com.cust.domain.vo.ElegantSupplier;
import com.cust.util.ElegantUtil;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class SupplierDaoImpl extends HibernateDaoSupport implements SupplierDao, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(SupplierDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ElegantSupplier getSupplierById(long compId, long supId)
            throws ApplicationException {
        ElegantSupplier supplier = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getSupplierById");
            query.setParameter(0, compId);
            query.setParameter(1, supId);
            if (!query.list().isEmpty()) {
                supplier = (ElegantSupplier) query.list().get(0);
            }
            if (logger.isDebugEnabled()) logger.debug(" getSupplierById () " + compId, " - " + supId);
        } catch (Exception e) {
            logger.error("Error getSupplierById() " + e.getMessage());
            throw new ApplicationException("Error getSupplierById() "
                    + e.getMessage());
        }

        return supplier;
    }

    @Override
    public ArrayList<ElegantSupplier> getAllSuppliers(ServiceControl serviceControl, long compId) throws ApplicationException {
        ArrayList<ElegantSupplier> customerList = null;
        Pagination pagination = serviceControl.getPagination();
        QueryCriteria queryCriteria;

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getAllSuppliers");
            String queryString = query.getQueryString();
            queryCriteria = serviceControl.getQueryCriteria();
            queryString += QueryUtility.getQueryCriteriaString(queryCriteria,
                    sessionFactory, new ElegantSupplier());
            query = session.createSQLQuery(queryString).addEntity(
                    ElegantSupplier.class);
            if (pagination != null) {
                int firstPage = (int) ((pagination.getCurrrentPageNumber() - 1) * pagination
                        .getMaxPageSize());
                query.setFirstResult(firstPage);
                query.setMaxResults((int) pagination.getMaxPageSize());
            }
            query.setParameter(0, compId);
            customerList = (ArrayList<ElegantSupplier>) query.list();
            if (logger.isDebugEnabled()) logger.debug(" getAllSuppliers() " + compId);            
        } catch (Exception e) {
            logger.error("Error getAllSuppiler() " + e.getMessage());
            throw new ApplicationException("Error getAllSupplier() "
                    + e.getMessage());
        }

        return customerList;
    }

    @Override
    public ArrayList<ElegantSupplier> saveSupplierList(ArrayList<ElegantSupplier> supplierList) throws ApplicationException {
        long key = 0;
        boolean updated=false;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantSupplier sup : supplierList) {
                if (sup.getUserID() == 0) {
                    throw new ApplicationException("saveSupplierList : -> UserId cannot be Zero");
                }
                if (sup.getSupID() == 0) {
                    key = getMaxSupKey(sup.getCompID());
                    sup.setSupID(key);
                    if (sup.getCreateDate() == null) {
                        sup.setCreateDate(new Date());
                    }
                }
                session.saveOrUpdate(sup);
                updated=true;
            }
            if (logger.isDebugEnabled()) logger.debug("saveSupplierList() " + supplierList.size());
            if (updated) session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[3]));
        } catch (Exception e) {
            logger.error("saveSupplierList : -> " + e.getMessage());
            throw new ApplicationException("saveSupplierList : -> "
                    + e.getMessage());
        }
        return supplierList;
    }

    private long getMaxSupKey(long compId) throws ApplicationException {

        Long custId = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxSupKey");
            query.setParameter(0, compId);
            custId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxSupKey: -> " + e.getMessage());
            throw new ApplicationException("getMaxSupKey: -> "
                    + e.getMessage());
        }
        return custId;
    }

    @Override
    public Boolean deleteSupplierList(ArrayList<ElegantSupplier> supList) throws ApplicationException {
        int countDeleted=0,elementCount=0;
        boolean updated=false;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantSupplier supp : supList) {
                Query query = session.getNamedQuery("deleteSupplier");
                query.setParameter(0, supp.getCompID());
                query.setParameter(1, supp.getSupID());
                query.setParameter(2, supp.getCompID());                
                countDeleted = query.executeUpdate();
                if (countDeleted>0) {
                    elementCount++;
                    updated=true;
                }
            }
            if (logger.isDebugEnabled()) logger.debug("deleteSupplierList " + supList.size());
            if (updated) session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[3]));
        } catch (Exception e) {
            logger.error("deleteSupplierList() " + e.getMessage());
            throw new ApplicationException("deleteSupplierList() "
                    + e.getMessage());
        }
        return elementCount == supList.size();
    }

}
