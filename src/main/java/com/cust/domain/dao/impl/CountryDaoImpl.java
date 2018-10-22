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
import com.cust.domain.dao.CountryDao;
import com.cust.domain.vo.ElegantCountry;
import com.cust.util.ElegantUtil;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author Inderjit
 */
public class CountryDaoImpl extends HibernateDaoSupport implements CountryDao, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(CountryDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ElegantCountry getCountryById(int countryId) throws ApplicationException {
        ElegantCountry elegantCountry = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getCountryById");
            query.setParameter(0, countryId);
            if (!query.list().isEmpty()) {
                elegantCountry = (ElegantCountry) query.list().get(0);
            }
            if (logger.isDebugEnabled()) logger.debug("getCountryById " + countryId);
        } catch (Exception e) {
            logger.error("Error getCountryById() " + e.getMessage());
            throw new ApplicationException("Error getCountryById() "
                    + e.getMessage());
        }
        return elegantCountry;

    }

    @Override
    public ArrayList<ElegantCountry> getAllCountries(ServiceControl serviceControl)
            throws ApplicationException {
        ArrayList<ElegantCountry> elegantCountryList = null;
        Pagination pagination = serviceControl.getPagination();
        QueryCriteria queryCriteria;

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getAllCountries");
            String queryString = query.getQueryString();

            queryCriteria = serviceControl.getQueryCriteria();
            queryString += QueryUtility.getQueryCriteriaString(queryCriteria,
                    sessionFactory, new ElegantCountry());
            query = session.createSQLQuery(queryString).addEntity(
                    ElegantCountry.class);
            if (pagination != null) {
                int firstPage = (int) ((pagination.getCurrrentPageNumber() - 1) * pagination
                        .getMaxPageSize());
                query.setFirstResult(firstPage);
                query.setMaxResults((int) pagination.getMaxPageSize());
            }
            elegantCountryList = (ArrayList<ElegantCountry>) query.list();
            if (logger.isDebugEnabled()) logger.debug("getAllCustomers " );
        } catch (Exception e) {
            logger.error("Error getAllCountries() " + e.getMessage());
            throw new ApplicationException("Error getAllCountries() "
                    + e.getMessage());
        }
        return elegantCountryList;
    }

    @Override
    public ArrayList<ElegantCountry> saveCountryList(ArrayList<ElegantCountry> countryList)
            throws ApplicationException {
        long key = 0;
        boolean updated=false;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantCountry country : countryList) {
                if (country.getCountryID() == 0) {
                    key = getMaxCountryKey();
                    country.setCountryID(key);
                    country.setCreateDate(new Date());
                    country.setDisabled(0);
                }
                session.saveOrUpdate(country);
                updated=true;
            }
            if (updated) session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[0]));
            if (logger.isDebugEnabled()) logger.debug("saveCountryList " + countryList.size());
        } catch (Exception e) {
            logger.error("Error saveCountryList() " + e.getMessage());
            throw new ApplicationException("Error saveCountryList() "
                    + e.getMessage());

        }
        return countryList;

    }

    private long getMaxCountryKey() throws ApplicationException {

        Long countryId = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxCountryKey");
            countryId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxCountryKey() " + e.getMessage());
            throw new ApplicationException("getMaxCountryKey() " + e.getMessage());
        }
        return countryId;
    }

    @Override
    public Boolean deleteCountryList(ArrayList<ElegantCountry> countryList)
            throws ApplicationException {
        int countDeleted=0,deletedCount=0;
        boolean updated=false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantCountry country : countryList) {
                Query query = session.getNamedQuery("deleteCountry");
                query.setParameter(0, country.getCountryID());
                countDeleted = query.executeUpdate();
                if(countDeleted>0) {
                    deletedCount++;
                    updated=true;
                }
            }
            if (updated) session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[1]));            
            if (logger.isDebugEnabled()) logger.debug("deleteCountryList " + countryList.size() );
        } catch (Exception e) {
            logger.error("deleteCountryList() " + e.getMessage());
            throw new ApplicationException("deleteCountryList() " + e.getMessage());
        }
        return deletedCount==countryList.size();
    }

}
