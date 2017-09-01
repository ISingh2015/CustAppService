package com.cust.domain.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import com.cust.common.ApplicationException;
import com.cust.common.Pagination;
import com.cust.common.QueryCriteria;
import com.cust.common.QueryUtility;
import com.cust.common.ServiceControl;
import com.cust.domain.dao.BuySellDao;
import com.cust.domain.dao.CustomerDao;
import com.cust.domain.dao.ProductDao;
import com.cust.domain.dao.SalesManDao;
import com.cust.domain.dao.SupplierDao;
import com.cust.domain.vo.ElegantBuySell;
import com.cust.domain.vo.ElegantBuySellConsolidation;
import com.cust.domain.vo.ElegantBuySellDetails;
import com.cust.domain.vo.ElegantCustomer;
import com.cust.domain.vo.ElegantMailList;
import com.cust.domain.vo.ElegantMarketMail;
import com.cust.domain.vo.ElegantProduct;
import com.cust.domain.vo.ElegantSalesMan;
import com.cust.domain.vo.ElegantSupplier;
import com.cust.util.CustMailManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BuySellDaoImpl extends HibernateDaoSupport implements BuySellDao, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(BuySellDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SupplierDao elegantSupplierDao;

    @Autowired
    private CustomerDao elegantCustomerDao;

    @Autowired
    private SalesManDao elegantSalesManDao;

    @Autowired
    private ProductDao elegantProductDao;

    @Autowired
    private CustMailManager custMailer;

    @Override
    public ElegantBuySell getBuySellById(long compId, long billId)
            throws ApplicationException {
        ElegantBuySell buySell = null;
        ElegantSupplier elegantSupplier;
        ElegantCustomer elegantCustomer;
        ElegantSalesMan elegantSalesMan;
        ElegantProduct elegantProduct;
        ArrayList<ElegantBuySellDetails> buySellDetailsList = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getBuySellById");
            query.setParameter(0, compId);
            query.setParameter(1, billId);
            if (!query.list().isEmpty()) {
                buySell = (ElegantBuySell) query.list().get(0);
                if (buySell.getBillType() == 100) {
                    elegantSupplier = elegantSupplierDao.getSupplierById(compId, buySell.getBuyerSellerCode());
                    if (elegantSupplier != null) {
                        buySell.setBuyerSellerName(elegantSupplier.getSupName());
                    }
                }
                if (buySell.getBillType() == 200) {
                    elegantCustomer = elegantCustomerDao.getCustomerById(compId, buySell.getBuyerSellerCode());
                    if (elegantCustomer != null) {
                        buySell.setBuyerSellerName(elegantCustomer.getCustName());
                    }
                }
                elegantSalesMan = elegantSalesManDao.getSalesManById(compId, buySell.getSalesManCode());
                if (elegantSalesMan != null) {
                    buySell.setSalesManName(elegantSalesMan.getSalesManName());
                }
                buySellDetailsList = getBuySellDetails(compId, billId);
                if (buySellDetailsList != null) {
                    buySell.setBuySellDetailsList(buySellDetailsList);
                    for (ElegantBuySellDetails elegantBuySellDetails : buySellDetailsList) {
                        elegantProduct = elegantProductDao.getProductById(compId, elegantBuySellDetails.getProductId());
                        if (elegantProduct != null) {
                            elegantBuySellDetails.setProductName(elegantProduct.getProdName());
                            elegantBuySellDetails.setInStock(elegantProduct.getMinInStock());
//                            elegantBuySellDetails.setPurchRate(elegantProduct.getStandardCost());
                        }
                    }
                }
            }
            if (logger.isDebugEnabled()) {
                logger.debug("getBuySellById " + compId + " - " + billId);
            }
        } catch (Exception e) {
            logger.error("Error getBuySellById() " + e.getMessage());
            throw new ApplicationException("Error getBuySellById() "
                    + e.getMessage());
        }

        return buySell;
    }

    @Override
    public ArrayList<ElegantBuySell> getAllBuySell(ServiceControl serviceControl, long compId, boolean forRep) throws ApplicationException {
        ArrayList<ElegantBuySell> buySellList = null;
        Pagination pagination = serviceControl.getPagination();
        QueryCriteria queryCriteria;
        ElegantSupplier elegantSupplier;
        ElegantCustomer elegantCustomer;
        ElegantSalesMan elegantSalesMan;
        ElegantProduct elegantProduct;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getAllBuySell");
            String queryString = query.getQueryString();
            queryCriteria = serviceControl.getQueryCriteria();
            queryString += QueryUtility.getQueryCriteriaString(queryCriteria,
                    sessionFactory, new ElegantBuySell());
            query = session.createSQLQuery(queryString).addEntity(
                    ElegantBuySell.class);
            if (pagination != null) {
                int firstPage = (int) ((pagination.getCurrrentPageNumber() - 1) * pagination
                        .getMaxPageSize());
                query.setFirstResult(firstPage);
                query.setMaxResults((int) pagination.getMaxPageSize());
            }
            query.setParameter(0, compId);
            buySellList = (ArrayList<ElegantBuySell>) query.list();
            if (forRep) {
                return buySellList;
            }
            for (ElegantBuySell buySell : buySellList) {

                if (buySell.getBillType() == 0) {
                    elegantSupplier = elegantSupplierDao.getSupplierById(compId, buySell.getBuyerSellerCode());
                    if (elegantSupplier != null) {
                        buySell.setBuyerSellerName(elegantSupplier.getSupName());
                    }
                }
                if (buySell.getBillType() == 1) {
                    elegantCustomer = elegantCustomerDao.getCustomerById(compId, buySell.getBuyerSellerCode());
                    if (elegantCustomer != null) {
                        buySell.setBuyerSellerName(elegantCustomer.getCustName());
                    }
                }
                elegantSalesMan = elegantSalesManDao.getSalesManById(compId, buySell.getSalesManCode());
                if (elegantSalesMan != null) {
                    buySell.setSalesManName(elegantSalesMan.getSalesManName());
                }

                ArrayList<ElegantBuySellDetails> buySellDetailsList = getBuySellDetails(buySell.getCompID(), buySell.getBillID());
                if (buySellDetailsList != null) {
                    buySell.setBuySellDetailsList(buySellDetailsList);
                    for (ElegantBuySellDetails elegantBuySellDetails : buySellDetailsList) {
                        elegantProduct = elegantProductDao.getProductById(compId, elegantBuySellDetails.getProductId());
                        if (elegantProduct != null) {
                            elegantBuySellDetails.setProductName(elegantProduct.getProdName());
                        }
                    }

                }
            }
            if (logger.isDebugEnabled()) {
                logger.debug("getAllBuySell " + compId);
            }
        } catch (Exception e) {
            logger.error("Error getAllBuySell() " + e.getMessage());
            throw new ApplicationException("Error getAllBuySell() "
                    + e.getMessage());
        }

        return buySellList;
    }

    @Override
    public ArrayList<ElegantBuySell> saveBuySellList(ArrayList<ElegantBuySell> buySellList, boolean updateStock) throws ApplicationException {
        long key = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantBuySell buySell : buySellList) {
                if (buySell.getUserID() == 0) {
                    throw new ApplicationException("saveBuySellList : -> UserId cannot be Zero");
                }
                if (buySell.getBillID() == 0) {
                    key = getMaxBillKey(buySell.getCompID());
                    buySell.setBillID(key);
                    if (buySell.getCreateDate() == null) {
                        buySell.setCreateDate(new Date());
                    }
                }
                session.saveOrUpdate(buySell);
                if (buySell.getBuySellDetailsList() != null) {
                    deleteBuySellDetailsNoUpdate(buySell);
                    for (ElegantBuySellDetails buySellDetails : buySell.getBuySellDetailsList()) {
                        if (buySellDetails.getCompID() == 0) {
                            buySellDetails.setCompID(buySell.getCompID());
                        }
                        if (buySellDetails.getBillID() == 0) {
                            buySellDetails.setBillID(buySell.getBillID());
                        }
                        session.saveOrUpdate(buySellDetails);
                        session.flush();
                    }
                    if (updateStock) {
                        for (ElegantBuySellDetails buySellDetails : buySell.getBuySellDetailsList()) {
                            updateStockForProduct(buySellDetails);
                        }
                    }

                }
            }
            if (logger.isDebugEnabled()) {
                logger.debug("saveBuySell  " + buySellList.size());
            }
        } catch (Exception e) {
            logger.error("saveBuySellList : -> " + e.getMessage());
            throw new ApplicationException("saveBuySellList : -> "
                    + e.getMessage());
        }
        return buySellList;
    }

    private boolean updateStockForProduct(ElegantBuySellDetails elegantBuySellDetails) throws ApplicationException {
        int noUpdated = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("updateStockQuery");
            query.setParameter(0, elegantBuySellDetails.getCompID());
            query.setParameter(1, elegantBuySellDetails.getProductId());
            query.setParameter(2, elegantBuySellDetails.getCompID());
            query.setParameter(3, elegantBuySellDetails.getProductId());
            query.executeUpdate();

        } catch (Exception e) {
            logger.error("updateStockForProduct: -> " + e.getMessage());
            throw new ApplicationException("updateStockForProduct: -> "
                    + e.getMessage());
        }
        return noUpdated > 0;

    }

    private long getMaxBillKey(long compId) throws ApplicationException {

        Long custId = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxBillKey");
            query.setParameter(0, compId);
            custId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxBillKey: -> " + e.getMessage());
            throw new ApplicationException("getMaxBillKey: -> "
                    + e.getMessage());
        }
        return custId;
    }

    private boolean deleteBuySellDetails(ElegantBuySell elegantBuySell) throws ApplicationException {
        int noDeleted = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("deleteBuySellItem");
            query.setParameter(0, elegantBuySell.getCompID());
            query.setParameter(1, elegantBuySell.getBillID());
            noDeleted = query.executeUpdate();
            if (noDeleted == elegantBuySell.getBuySellDetailsList().size()) {
                for (ElegantBuySellDetails elegantBuySellDetails : elegantBuySell.getBuySellDetailsList()) {
                    updateStockForProduct(elegantBuySellDetails);
                }
            }
        } catch (Exception e) {
            logger.error("deleteBuySellDetails() " + e.getMessage());
            throw new ApplicationException("deleteBuySellDetails() "
                    + e.getMessage());
        }
        return noDeleted == elegantBuySell.getBuySellDetailsList().size();
    }

    private boolean deleteBuySellDetailsNoUpdate(ElegantBuySell elegantBuySell) throws ApplicationException {
        int noDeleted = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("deleteBuySellItem");
            query.setParameter(0, elegantBuySell.getCompID());
            query.setParameter(1, elegantBuySell.getBillID());
            noDeleted = query.executeUpdate();
        } catch (Exception e) {
            logger.error("deleteBuySellDetails() " + e.getMessage());
            throw new ApplicationException("deleteBuySellDetails() "
                    + e.getMessage());
        }
        return noDeleted == elegantBuySell.getBuySellDetailsList().size();
    }

    @Override
    public Boolean deleteBuySellList(ArrayList<ElegantBuySell> buySellList) throws ApplicationException {
        int noDeleted = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantBuySell buySell : buySellList) {
                Query query = session.getNamedQuery("deleteBuySell");
                query.setParameter(0, buySell.getCompID());
                query.setParameter(1, buySell.getCompID());
                query.setParameter(2, buySell.getCompID());
                query.setParameter(3, buySell.getBillType());
                query.setParameter(4, buySell.getBillID());
                noDeleted = query.executeUpdate();
                if (noDeleted > 0) {
                    deleteBuySellDetails(buySell);
                }
            }
            if (logger.isDebugEnabled()) {
                logger.debug("deleteBbuySellList " + buySellList.size());
            }
        } catch (Exception e) {
            logger.error("deleteBuySellList() " + e.getMessage());
            throw new ApplicationException("deleteBuySellList() "
                    + e.getMessage());
        }
        return noDeleted > 0 && buySellList.size() == noDeleted;
    }

    private ArrayList<ElegantBuySellDetails> getBuySellDetails(long compId, long billId)
            throws ApplicationException {
        ArrayList<ElegantBuySellDetails> buySellDetailsList = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getBuySellDetails");
            query.setParameter(0, compId);
            query.setParameter(1, billId);
            query.setParameter(2, compId);
            buySellDetailsList = (ArrayList<ElegantBuySellDetails>) query.list();
        } catch (Exception e) {
            logger.error("Error getBuySellDetails() " + e.getMessage());
            throw new ApplicationException("Error getBuySellDetails() "
                    + e.getMessage());
        }

        return buySellDetailsList;
    }

    @Override
    public ArrayList<ElegantBuySellConsolidation> getAllBuySellForReport(ServiceControl serviceControl, long compId, int salesManId, long productId, String buyerSellerCode, Date fromDate, Date toDate, String billType) throws ApplicationException {
        ArrayList<ElegantBuySellConsolidation> buySellList = null;
        String frmDt = new SimpleDateFormat("YYYY/MM/dd").format(fromDate);
        String toDt = new SimpleDateFormat("YYYY/MM/dd").format(toDate);
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getAllBuySellForReport");
            query.setParameter(0, compId);
            query.setParameter(1, salesManId);
            query.setParameter(2, productId);
            query.setParameter(3, buyerSellerCode);
            query.setParameter(4, frmDt);
            query.setParameter(5, toDt);
            query.setParameter(6, billType);
            query.setResultTransformer(Transformers.aliasToBean(ElegantBuySellConsolidation.class));
            buySellList = (ArrayList<ElegantBuySellConsolidation>) query.list();
            if (logger.isDebugEnabled()) {
                logger.debug("getBuySellForReport " + compId);
            }
        } catch (Exception e) {
            logger.error("Error getAllBuySellForReport() " + e.getMessage());
            throw new ApplicationException("Error getAllBuySellForReport() "
                    + e.getMessage());
        }

        return buySellList;

    }

    @Override
    public ArrayList<ElegantMailList> getGlobalMailingList(ServiceControl serviceControl) throws ApplicationException {
        ArrayList<ElegantMailList> buySellEmailList = null;
        Pagination pagination = serviceControl.getPagination();
        QueryCriteria queryCriteria;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getBuySellEmailList");
            String queryString = query.getQueryString();
            queryCriteria = serviceControl.getQueryCriteria();
            queryString += QueryUtility.getQueryCriteriaString(queryCriteria,
                    sessionFactory, new ElegantMailList());
            query = session.createSQLQuery(queryString).addEntity(
                    ElegantMailList.class);
            if (pagination != null) {
                int firstPage = (int) ((pagination.getCurrrentPageNumber() - 1) * pagination
                        .getMaxPageSize());
                query.setFirstResult(firstPage);
                query.setMaxResults((int) pagination.getMaxPageSize());
            }

            buySellEmailList = (ArrayList<ElegantMailList>) query.list();
        } catch (Exception e) {
            logger.error("Error getGlobalMailingList() " + e.getMessage());
            throw new ApplicationException("Error getGlobalMailingList "
                    + e.getMessage());
        }
        return buySellEmailList;
    }

    private long getMaxSrlKey() throws ApplicationException {

        Long srlId = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxSrlKey");
            srlId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxSrlKey: -> " + e.getMessage());
            throw new ApplicationException("getMaxSrlKey: -> "
                    + e.getMessage());
        }
        return srlId;
    }

    @Override
    public ArrayList<ElegantMarketMail> saveGlobalMailingList(ServiceControl serviceControl, ArrayList<ElegantMarketMail> emailList) throws ApplicationException {
        long key = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantMarketMail elegantMarketMail : emailList) {
                if (elegantMarketMail.getEmailToAddress().equals("") && elegantMarketMail.getEmailCcAddress().equals("") && elegantMarketMail.getEmailBccAddress().equals("")) {
                    continue;
                }
                if (elegantMarketMail.getSrlId() == 0) {
                    key = getMaxSrlKey();
                    elegantMarketMail.setSrlId(key);
                    elegantMarketMail.setCreateDate(new Date());
                }
                session.saveOrUpdate(elegantMarketMail);
                sendEmailToUser(elegantMarketMail.getEmailToAddress(), elegantMarketMail.getEmailCcAddress(), elegantMarketMail.getEmailBccAddress(), elegantMarketMail.getEmailSubject(), elegantMarketMail.getEmailMessage());
            }
            session.flush();
            if (logger.isDebugEnabled()) {
                logger.debug("saveGlobalMailingList  " + emailList.size());
            }
        } catch (Exception e) {
            logger.error("saveGlobalMailingList : -> " + e.getMessage());
            throw new ApplicationException("saveGlobalMailingList : -> "
                    + e.getMessage());
        }
        return emailList;
    }

    private boolean sendEmailToUser(String to, String cc, String bcc, String subj, String message) {
        boolean emailSent = false;
        try {
            String mailFrom = "eleganinfo@gmail.com";
            String mailSubject = subj;
            custMailer.sendMail(mailFrom, to, cc,bcc,mailSubject, message);
            emailSent = true;
        } catch (Exception e) {
            logger.error("Error sendEmailToUserWithPwd() " + e.getMessage());
        }
        return emailSent;
    }

}
