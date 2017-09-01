package com.cust.domain.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.cust.common.ApplicationException;
import com.cust.common.Pagination;
import com.cust.common.QueryCriteria;
import com.cust.common.QueryUtility;
import com.cust.common.ServiceControl;
import com.cust.domain.dao.CustomerDao;
import com.cust.domain.vo.ElegantCustomer;
import com.cust.util.ElegantUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ElegantCustomer getCustomerById(long compId, long custId)
            throws ApplicationException {
        ElegantCustomer customer = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getCustomerById");
            query.setParameter(0, compId);
            query.setParameter(1, custId);
            if (!query.list().isEmpty()) {
                customer = (ElegantCustomer) query.list().get(0);
            }
            if (logger.isDebugEnabled()) logger.debug("getCustomerById " + compId + " - " + custId);
        } catch (Exception e) {
            logger.error("Error getCustomerById() " + e.getMessage());
            throw new ApplicationException("Error getCustomerById() "
                    + e.getMessage());
        }

        return customer;
    }

    @Override
    public List<ElegantCustomer> getAllCustomers(ServiceControl serviceControl, long compId) throws ApplicationException {
        List<ElegantCustomer> customerList = null;
        Pagination pagination = serviceControl.getPagination();
        QueryCriteria queryCriteria;

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getAllCustomers");
            String queryString = query.getQueryString();
            queryCriteria = serviceControl.getQueryCriteria();
            queryString += QueryUtility.getQueryCriteriaString(queryCriteria,
                    sessionFactory, new ElegantCustomer());
            query = session.createSQLQuery(queryString).addEntity(
                    ElegantCustomer.class);
            if (pagination != null) {
                int firstPage = (int) ((pagination.getCurrrentPageNumber() - 1) * pagination
                        .getMaxPageSize());
                query.setFirstResult(firstPage);
                query.setMaxResults((int) pagination.getMaxPageSize());
            }
            query.setParameter(0, compId);
            customerList = (List<ElegantCustomer>) query.list();
            if (logger.isDebugEnabled()) logger.debug("getAllCustomers " + compId);
        } catch (Exception e) {
            logger.error("Error getAllCustomers() " + e.getMessage());
            throw new ApplicationException("Error getAllCustomers() "
                    + e.getMessage());
        }

        return customerList;
    }

    @Override
    public ArrayList<ElegantCustomer> saveCustomerList(ArrayList<ElegantCustomer> customerList) throws ApplicationException {
        long key = 0;
        boolean updated = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantCustomer cust : customerList) {
                if (cust.getUserID() == 0) {
                    throw new ApplicationException("saveCustomerList: -> UserId cannot be Zero");

                }
                if (cust.getCustID() == 0) {
                    key = getMaxCustKey(cust.getCompID());
                    cust.setCustID(key);
                    if (cust.getCreateDate() == null) {
                        cust.setCreateDate(new Date());
                    }
                }
                session.saveOrUpdate(cust);
                updated=true;
            }
            if (updated) session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[4]));
            if (logger.isDebugEnabled()) logger.debug("saveCustomerList " + customerList.size());
        } catch (Exception e) {
            logger.error("saveCustomerList : -> " + e.getMessage());
            throw new ApplicationException("saveCustomerList: -> "
                    + e.getMessage());
        }
        return customerList;
    }

    private long getMaxCustKey(long compId) throws ApplicationException {

        Long custId = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxCustKey");
            query.setParameter(0, compId);
            custId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxCustKey: -> " + e.getMessage());
            throw new ApplicationException("getMaxCustKey: -> "
                    + e.getMessage());
        }
        return custId;
    }

    @Override
    public Boolean deleteCustomerList(ArrayList<ElegantCustomer> custList) throws ApplicationException {
        int countDeleted=0,elementCount=0;
        boolean updated=false;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantCustomer cust : custList) {
                Query query = session.getNamedQuery("deleteCustomer");
                query.setParameter(0, cust.getCompID());
                query.setParameter(1, cust.getCustID());
                query.setParameter(2, cust.getCompID());                
                countDeleted = query.executeUpdate();
                if (countDeleted>0) {
                    elementCount++;
                    updated=true;
                }
            }
            if (updated) session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[4]));
            if (logger.isDebugEnabled()) logger.debug("deleteCustomerList " + " - " + custList.size());
        } catch (Exception e) {
            logger.error("deleteCustomerList() " + e.getMessage());
            throw new ApplicationException("deleteCustomerList() "
                    + e.getMessage());
        }
        return elementCount==custList.size();
    }

}
