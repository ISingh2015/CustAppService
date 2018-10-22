package com.cust.domain.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.cust.common.ApplicationException;
import com.cust.common.Pagination;
import com.cust.common.QueryCriteria;
import com.cust.common.QueryUtility;
import com.cust.common.ServiceControl;
import com.cust.domain.dao.ProductDao;
import com.cust.domain.vo.ElegantProduct;
import com.cust.util.ElegantUtil;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ElegantProduct getProductById(long compId, long prodId)
            throws ApplicationException {
        ElegantProduct product = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getProductById");
            query.setParameter(0, compId);
            query.setParameter(1, prodId);
            if (!query.list().isEmpty()) {
                product = (ElegantProduct) query.list().get(0);
            }
            if (logger.isDebugEnabled()) {
                logger.debug("getPRoductById " + compId + " - " + prodId);
            }
        } catch (Exception e) {
            logger.error("Error getProductById() " + e.getMessage());
            throw new ApplicationException("Error getProductById() "
                    + e.getMessage());
        }

        return product;
    }

    @Override
    public ArrayList<ElegantProduct> getAllProducts(ServiceControl serviceControl, long compId) throws ApplicationException {
        ArrayList<ElegantProduct> productList = null;
        Pagination pagination = serviceControl.getPagination();
        QueryCriteria queryCriteria;

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getAllProducts");
            String queryString = query.getQueryString();
            queryCriteria = serviceControl.getQueryCriteria();
            queryString += QueryUtility.getQueryCriteriaString(queryCriteria,
                    sessionFactory, new ElegantProduct());
            query = session.createSQLQuery(queryString).addEntity(
                    ElegantProduct.class);
            if (pagination != null) {
                int firstPage = (int) ((pagination.getCurrrentPageNumber() - 1) * pagination
                        .getMaxPageSize());
                query.setFirstResult(firstPage);
                query.setMaxResults((int) pagination.getMaxPageSize());
            }
            query.setParameter(0, compId);
            productList = (ArrayList<ElegantProduct>) query.list();
            if (logger.isDebugEnabled()) {
                logger.debug("getAllProducts " + compId);
            }
        } catch (Exception e) {
            logger.error("Error getAllProducts() " + e.getMessage());
            throw new ApplicationException("Error getAllProducts() "
                    + e.getMessage());
        }

        return productList;
    }

    @Override
    public ArrayList<ElegantProduct> saveProductList(ArrayList<ElegantProduct> productList) throws ApplicationException {
        long key = 0;
        boolean updated = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantProduct product : productList) {
                if (product.getUserID() == 0) {
                    throw new ApplicationException("saveProductList : -> UserId cannot be Zero");
                }
                if (product.getProdID() == 0) {
                    key = getMaxProdKey(product.getCompID());
                    product.setProdID(key);
                    if (product.getCreateDate() == null) {
                        product.setCreateDate(new Date());
                    }
                }
                session.saveOrUpdate(product);
                updated = true;
            }
            if (updated) {
                session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[2]));
            }
            if (logger.isDebugEnabled()) {
                logger.debug("saveProductList " + productList.size());
            }
        } catch (Exception e) {
            logger.error("saveProductList : -> " + e.getMessage());
            throw new ApplicationException("saveProductList : -> "
                    + e.getMessage());
        }
        return productList;
    }

    private long getMaxProdKey(long compId) throws ApplicationException {

        Long custId = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxProdKey");
            query.setParameter(0, compId);
            custId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxProdKey: -> " + e.getMessage());
            throw new ApplicationException("getMaxProdKey: -> "
                    + e.getMessage());
        }
        return custId;
    }

    @Override
    public Boolean deleteProductList(ArrayList<ElegantProduct> productList) throws ApplicationException {
        int countDeleted = 0, elementCount = 0;
        boolean updated = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantProduct prod : productList) {
                Query query = session.getNamedQuery("deleteProduct");
                query.setParameter(0, prod.getCompID());
                query.setParameter(1, prod.getProdID());
                countDeleted = query.executeUpdate();
                if (countDeleted > 0) {
                    elementCount++;
                    updated = true;
                }
            }
            if (updated) {
                session.saveOrUpdate(ElegantUtil.createUpdateVO(ElegantUtil.UPDATED[1]));
            }
            if (logger.isDebugEnabled()) {
                logger.debug("deleteProductList " + productList.size());
            }
        } catch (Exception e) {
            logger.error("deleteProductList() " + e.getMessage());
            throw new ApplicationException("deleteProductList() "
                    + e.getMessage());
        }
        return elementCount == productList.size();
    }

    @Override
    public Double getProductStockById(long compId, long prodId, long currBill) throws ApplicationException {
        ArrayList<Double> productStock = null;
        Double stockValue = 0d;
        Query query = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            query = session.getNamedQuery("getProductStockById");
            query.setParameter(0, compId);
            query.setParameter(1, prodId);
            query.setParameter(2, currBill);            
            productStock = (ArrayList<Double>) query.list();
            for (Double stockVal : productStock) {
                stockValue += stockVal;
            }
            if (logger.isDebugEnabled()) {
                logger.debug("getProductStockById " + compId + " - " + prodId + " - " + currBill);
            }
        } catch (Exception e) {
            logger.error("Error getProductStockById() " + e.getMessage());
            throw new ApplicationException("Error getProductStockById() "
                    + e.getMessage());
        }

        return stockValue;
    }
}
