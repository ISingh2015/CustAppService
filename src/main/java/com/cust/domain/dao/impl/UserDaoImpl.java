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
import com.cust.common.SendEmailClient;
import com.cust.common.ServiceControl;
import com.cust.domain.dao.UserDao;
import com.cust.domain.vo.ElegantClientsAndUpdates;
import com.cust.domain.vo.ElegantHitCounter;
import com.cust.domain.vo.ElegantUser;
import com.cust.domain.vo.ElegantUserAccess;
import com.cust.domain.vo.ElegantUserActivation;
import com.cust.domain.vo.ElegantUserLogin;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao, Serializable {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private ElegantClientsAndUpdates elegantClientsAndUpdates;

    @Autowired
    private SessionFactory sessionFactory;

    private long getMaxUserKey(ElegantUser user) throws ApplicationException {
        Long userId = null;
        if (user.getCompID() == 0) {
            logger.error("getMaxUserKey() Company Id cannot be zero");
            throw new ApplicationException("getMaxUserKey() Company Id cannot be zero");
        }
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxUserKey");
            query.setParameter(0, user.getCompID());
            userId = (Long) query.list().get(0);
            if (logger.isDebugEnabled()) {
                logger.debug("created new User ID " + userId);
            }
        } catch (Exception e) {
            logger.error("getMaxUserKey() " + e.getMessage());
            throw new ApplicationException("getMaxUserKey() " + e.getMessage());
        }
        return userId;
    }

    private long getMaxUserKey(ElegantUserActivation user) throws ApplicationException {
        Long userId = null;
        if (user.getCompID() == 0) {
            logger.error("getMaxUserKey() Company Id cannot be zero");
            throw new ApplicationException("getMaxUserKey() Company Id cannot be zero");
        }
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxUserKeyAct");
            query.setParameter(0, user.getCompID());
            userId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxUserKey() " + e.getMessage());
            throw new ApplicationException("getMaxUserKey() " + e.getMessage());
        }
        return userId;
    }

    @Override
    public ElegantUser getLoginByUserNameAndPassword(String userName, String password) throws ApplicationException {
        ElegantUser elegantUser = null;
        if (userName.equals("") || password.equals("")) {
            return elegantUser;
        }
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getUserByNameAndPass");
            query.setParameter(0, userName);
            query.setParameter(1, password);
            if (!query.list().isEmpty()) {
                elegantUser = (ElegantUser) query.list().get(0);
                elegantUser.setElegantUserAccessList(getUserAccess(elegantUser));
                if (elegantUser.getElegantUserAccessList() == null) {
                    elegantUser.setElegantUserAccessList(populateNewAccessRights(elegantUser));
                }
                getElegantClientsAndUpdates().setClientCount(getElegantClientsAndUpdates().getClientCount());
            }
            if (elegantUser != null && logger.isDebugEnabled()) {
                logger.debug("getLoginByUserNameAndPassword() " + elegantUser.getCompID() + "- " + elegantUser.getUserID());
            }

        } catch (Exception e) {
            logger.error("Error getLoginByUserNameAndPassword() " + e.getMessage());
            throw new ApplicationException("Error getLoginByUserNameAndPassword() "
                    + e.getMessage());
        }

        return elegantUser;

    }

    @Override
    public ElegantUser getUserById(long compId, long iD) throws ApplicationException {
        ElegantUser elegantUser = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getUserById");
            query.setParameter(0, compId);
            query.setParameter(1, iD);
            if (!query.list().isEmpty()) {
                elegantUser = (ElegantUser) query.list().get(0);
                elegantUser.setElegantUserAccessList(getUserAccess(elegantUser));
                if (elegantUser.getElegantUserAccessList() == null) {
                    elegantUser.setElegantUserAccessList(populateNewAccessRights(elegantUser));
                }
            }
            if (logger.isDebugEnabled()) {
                logger.debug("getUserById() " + iD);
            }
        } catch (Exception e) {
            logger.error("Error getUserById() " + iD + " - " + e.getMessage());
            throw new ApplicationException("Error getUserById() " + iD + " - " + e.getMessage());
        }
        return elegantUser;
    }

    @Override
    public ArrayList<ElegantUser> getAllUsers(ServiceControl serviceControl, long compId) throws ApplicationException {
        ArrayList<ElegantUser> usersList;

        QueryCriteria queryCriteria;
        Pagination pagination;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getAllUsers");
            String queryString = query.getQueryString();
            queryCriteria = serviceControl.getQueryCriteria();
            queryString += QueryUtility.getQueryCriteriaString(queryCriteria,
                    sessionFactory, new ElegantUser());
            query = session.createSQLQuery(queryString).addEntity(
                    ElegantUser.class);
            pagination = serviceControl.getPagination();
            if (pagination != null) {
                int firstPage = (int) ((pagination.getCurrrentPageNumber() - 1) * pagination
                        .getMaxPageSize());
                query.setFirstResult(firstPage);
                query.setMaxResults((int) pagination.getMaxPageSize());
            }
            query.setParameter(0, compId);
            usersList = (ArrayList<ElegantUser>) query.list();
            if (usersList != null) {
                for (ElegantUser elegantUser : usersList) {
                    ArrayList<ElegantUserAccess> userAccessList = getUserAccess(elegantUser);
                    if (userAccessList == null) {
                        elegantUser.setElegantUserAccessList(populateNewAccessRights(elegantUser));
                    } else {
                        elegantUser.setElegantUserAccessList(userAccessList);
                    }
                }
            }
            if (logger.isDebugEnabled()) {
                logger.debug("getAllUsers " + compId);
            }
        } catch (Exception e) {
            logger.error("Error getAllUsers() " + e.getMessage());
            throw new ApplicationException("Error getAllUsers() "
                    + e.getMessage());
        }

        return usersList;
    }

    private ArrayList<ElegantUserAccess> populateNewAccessRights(ElegantUser elegantUser) {
        ArrayList<ElegantUserAccess> elegantUserAccessList = new ArrayList<ElegantUserAccess>();
        for (int cnt = 1; cnt <= 52; cnt++) {
            ElegantUserAccess elegantUserAccess = new ElegantUserAccess();
            elegantUserAccess.setCompID(elegantUser.getCompID());
            elegantUserAccess.setUserID(elegantUser.getUserID());
            elegantUserAccess.setUserAccessId(cnt <= 40 ? 1000 + cnt : 2000 + (cnt - 40));
            boolean accessAllowed = false;
            int menuId = 0;
            if (cnt <= 40) {
                menuId = cnt;
            } else {
                menuId = cnt - 40;
            }
            if ((elegantUser.getAccountType() == 0 && elegantUserAccess.getUserAccessId() != 2008
                    && elegantUserAccess.getUserAccessId() != 1037)
                    || (elegantUser.getAccountType() != 0 && cnt <= 52)) {
                accessAllowed = true;
            }
            elegantUserAccess.setMenuId(menuId);
            elegantUserAccess.setMenuAllowed(accessAllowed);
            elegantUserAccessList.add(elegantUserAccess);
        }
        if (logger.isDebugEnabled()) {
            logger.info("Created application access rights for " + elegantUser.getCompID() + "-" + elegantUser.getUserID() + " - " + elegantUserAccessList.size());
        }
        return elegantUserAccessList;
    }

    @Override
    public ArrayList<ElegantUser> saveUserList(ArrayList<ElegantUser> userList, boolean createAccessRights) throws ApplicationException {
        long key = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantUser user : userList) {
                if (user.getUserID() == 0) {
                    key = getMaxUserKey(user);
                    user.setUserID(key);
                    user.setMembershipDate(new Date());
                    user.setAccountStatus(0); // 0=Normal 1=Frozen
                    logger.info("user Id created " + user.getUserID());
                }
                if (user.getAccountType() >= 1) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    long sec = calendar.getTime().getTime();

                    calendar.setTime(user.getMembershipDate());
                    long sec1 = calendar.getTime().getTime();

                    long graceLeft = (sec - sec1) / (1000 * 60 * 60 * 24);
                    user.setGracePeriod(new Long(graceLeft).intValue());
                }

                session.saveOrUpdate(user);
                if (createAccessRights) {
                    if (user.getElegantUserAccessList() == null || user.getElegantUserAccessList().isEmpty()) {
                        logger.info("creating user Access for user " + user.getUserLoginName());
                        user.setElegantUserAccessList(populateNewAccessRights(user));
                    } else {
                        for (ElegantUserAccess access : user.getElegantUserAccessList()) {
                            access.setUserID(user.getUserID());
                        }
                    }
                    saveUserAccess(user.getElegantUserAccessList());
                    if (logger.isDebugEnabled()) {
                        logger.debug("Saved User access list for user " + user.getUserLoginName() + "-" + user.getElegantUserAccessList().size());
                    }
                } else {
                    if (user.getLoggedIn() == 0) {
                        getElegantClientsAndUpdates().setClientCount(getElegantClientsAndUpdates().getClientCount() > 0 ? getElegantClientsAndUpdates().getClientCount() - 1 : 0);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error saveUserList() " + e.getMessage());
            throw new ApplicationException("Error saveUserList() " + e.getMessage());

        } finally {

        }
        return userList;
    }

    @Override
    public Boolean deleteUserList(ArrayList<ElegantUser> userList) throws ApplicationException {
        int count = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantUser user : userList) {
                Query query = session.getNamedQuery("deleteUser");
                query.setParameter(0, user.getCompID());
                query.setParameter(1, user.getUserID());
                count = query.executeUpdate();
                if (logger.isDebugEnabled()) {
                    logger.debug("deleteUserList " + user.getCompID() + " - " + user.getUserID());
                }
            }
            deleteUserAccess(userList);

        } catch (Exception e) {
            logger.error("Error deleteUserList() " + e.getMessage());
            throw new ApplicationException("Error deleteUserList() " + e.getMessage());

        }
        return count > 0;
    }

    private ArrayList<ElegantUserAccess> getUserAccess(ElegantUser user) throws ApplicationException {
        ArrayList<ElegantUserAccess> usersAccessList;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getUserAppAccess");
            query.setParameter(0, user.getCompID());
            query.setParameter(1, user.getUserID());
            usersAccessList = (ArrayList<ElegantUserAccess>) query.list();
        } catch (Exception e) {
            logger.error("Error getUsersAccess() " + e.getMessage());
            throw new ApplicationException("Error getUserAccess() " + e.getMessage());
        }
        return usersAccessList;

    }

    private ArrayList<ElegantUserAccess> saveUserAccess(ArrayList<ElegantUserAccess> userAccessList) throws ApplicationException {
        long key = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantUserAccess userAccess : userAccessList) {
                if (userAccess.getUserAccessId() == 0) {
                    key = getMaxUserAccessKey(userAccess);
                    userAccess.setUserID(key);
                }
                session.saveOrUpdate(userAccess);
            }
        } catch (Exception e) {
            logger.error("Error saveUserAccess() " + e.getMessage());
            throw new ApplicationException("Error saveUserAccess() " + e.getMessage());

        }
        return userAccessList;

    }

    private long getMaxUserAccessKey(ElegantUserAccess userAccess) throws ApplicationException {
        Long userId = null;
        if (userAccess.getCompID() == 0 || userAccess.getUserID() == 0) {
            logger.error("getMaxUserAccessKey() Company Id or User Id cannot be zero");
            throw new ApplicationException("getMaxUserAccessKey() Company Id or User Id cannot be zero");
        }
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxUseAccessrKey");
            query.setParameter(0, userAccess.getCompID());
            query.setParameter(1, userAccess.getUserID());
            userId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxUserAccessKey() " + e.getMessage());
            throw new ApplicationException("getMaxUserAccessKey() " + e.getMessage());
        }
        return userId;
    }

    private boolean deleteUserAccess(ArrayList<ElegantUser> userList) throws ApplicationException {
        boolean deleted = false;
        int count = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantUser user : userList) {
                Query query = session.getNamedQuery("deleteUserAccess");
                query.setParameter(0, user.getCompID());
                query.setParameter(1, user.getUserID());
                count = query.executeUpdate();
                deleted = count > 0;
            }
        } catch (Exception e) {
            logger.error("Error deleteUserAccessList() " + e.getMessage());
            throw new ApplicationException("Error deleteUserAccessList() " + e.getMessage());

        }
        return deleted;

    }

    @Override
    public ArrayList<ElegantUser> getUserByCriteria(ServiceControl serviceControl) throws ApplicationException {
        ArrayList<ElegantUser> usersList;
        QueryCriteria queryCriteria;
        Pagination pagination;
        Query query;
        try {
            Session session = sessionFactory.getCurrentSession();
            query = session.getNamedQuery("getByCriteria");
            String queryString = query.getQueryString();
            queryCriteria = serviceControl.getQueryCriteria();
            queryString += QueryUtility.getQueryCriteriaString(queryCriteria, sessionFactory, new ElegantUser());
            query = session.createSQLQuery(queryString).addEntity(ElegantUser.class);
            pagination = serviceControl.getPagination();
            if (pagination != null) {
                int firstPage = (int) ((pagination.getCurrrentPageNumber() - 1) * pagination
                        .getMaxPageSize());
                query.setFirstResult(firstPage);
                query.setMaxResults((int) pagination.getMaxPageSize());
            }
            usersList = (ArrayList<ElegantUser>) query.list();

            if (logger.isDebugEnabled()) {
                logger.debug("getUserByCriteria() ");
            }
        } catch (Exception e) {
            logger.error("Error getUserByCriteria() " + e.getMessage());
            throw new ApplicationException("Error getUserByCriteria " + e.getMessage());
        }
        return usersList;

    }

    @Override
    public ArrayList<ElegantUserActivation> saveUserActivation(ArrayList<ElegantUserActivation> userList, String mailTo) throws ApplicationException {
        long key = 0;
        ElegantUser elegantUser = new ElegantUser();
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantUserActivation user : userList) {
                if (user.getUserID() == 0) {
                    elegantUser.setCompID(user.getCompID());
                    elegantUser.setUserID(user.getUserID());
                    key = getMaxUserKey(elegantUser);
                    user.setUserID(key);
                }
                long no = System.currentTimeMillis();
                String str = Long.toString(no);
                byte[] encoded = Base64.getEncoder().encode(str.substring(7).getBytes());
                String s = new String(encoded);
                user.setUserActivation(s);
                if (sendEmailToUser(user, mailTo)) {
                    session.saveOrUpdate(user);
                    if (logger.isDebugEnabled()) {
                        logger.debug("created activation key " + user.getUserActivation());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error saveUserActivation() " + e.getMessage());
            throw new ApplicationException("Error saveUserActivation() " + e.getMessage());

        } finally {

        }
        return userList;
    }

    private boolean sendEmailToUser(ElegantUserActivation user, String mailTo) {
        boolean emailSent = false;
        try {
            String mailFrom = "eleganinfo@gmail.com";
//            String mailTo = new String("isanhot@ra.rockwell.com");
            String senderPassword = "foxpro123";
            String senderUserName = "eleganinfo";
            String mailSubject = "Elegant Inventory. Account Registration Code.";
            String mailText = "Please Use the below verification code to complete the Elegant Inventory Module registration process. <br><br><b>Verification code : </b>" + user.getUserActivation();
            mailText += "<br><br>Thank you for downloading the 30 day trial.";
            mailText += "<br>After completing registration you will be able to access the Inventory Module, enter data and print reports";
            mailText += "<br>See more product screen images <a href=http://www.elegantsoftware.in/pges/inventory.irp/>here</a> and to get in touch <a href=http://www.elegantsoftware.in/pges/contactPage.irp/>Click here</a>";
            mailText += "<br><br>Please do not respond or reply to this email message for queries as it is not monitored by the system.";
            mailText += "<br>Thank you once again. <b>The Elegant Software System Team.</b> ";
            SendEmailClient newGmailClient = new SendEmailClient();
            newGmailClient.setAccountDetails(senderUserName, senderPassword);
            newGmailClient.sendGmail(mailFrom, mailTo, mailSubject, mailText);
            if (logger.isDebugEnabled()) {
                logger.debug("Sending email <User Activation>" + mailTo);
            }
            emailSent = true;
        } catch (Exception e) {
            logger.error("Error sendEmailToUser() " + e.getMessage());
        }
        return emailSent;
    }

    private boolean sendEmailToUserWithPwd(ElegantUser user, String mailTo) {
        boolean emailSent = false;
        try {
            String mailFrom = "eleganinfo@gmail.com";
//            String mailTo = new String("isanhot@ra.rockwell.com");
            String senderPassword = "foxpro123";
            String senderUserName = "eleganinfo";
            String mailSubject = "Elegant Inventory. Account Login Pwd.";
            String newPwd = new String(Base64.getDecoder().decode(user.getUserLoginPwd().getBytes()));
            
            String mailText = "Dear " + user.getUserLoginName()+";<br><br>Please Use the below Generated password to Login to the Elegant Inventory Module <br><br><b>Generated Password : </b>" + newPwd;
            mailText +="<br><br>To get in touch <a href=http://www.elegantsoftware.in/pges/contactPage.irp/>click here</a>";
            mailText += "<br>Thank you once again. <b>The Elegant Software System Team.</b> ";
            SendEmailClient newGmailClient = new SendEmailClient();
            newGmailClient.setAccountDetails(senderUserName, senderPassword);
            if (logger.isDebugEnabled()) {
                logger.debug("Sending email <User Activation>" + mailTo + "-" + newPwd);
            }
            newGmailClient.sendGmail(mailFrom, mailTo, mailSubject, mailText);            
            emailSent = true;
        } catch (Exception e) {
            logger.error("Error sendEmailToUserWithPwd() " + e.getMessage());
        }
        return emailSent;
    }

    @Override
    public ArrayList<ElegantUserLogin> saveUserLogin(ArrayList<ElegantUserLogin> userLoginList) throws ApplicationException {
        long key = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantUserLogin user : userLoginList) {
                if (user.getCompID() == 0) {
                    logger.error("saveUserLogin() Company Id cannot be zero");
                    throw new ApplicationException("saveUserLogin() Company Id cannot be zero");
                }
                if (user.getUserID() == 0) {
                    logger.error("saveUserLogin() User Id cannot be zero");
                    throw new ApplicationException("saveUserLogin() User Id cannot be zero");
                }

                if (user.getUserLoginId() == 0) {
                    key = getMaxUserLoginKey(user);
                    user.setUserLoginId(key);
                    if (logger.isDebugEnabled()) {
                        logger.debug("saving user Login :: Login key :: " + user.getLoginIP() + " :: " + user.getUserID() + " :: " + user.getUserLoginId());
                    }
                }
                session.saveOrUpdate(user);
            }
        } catch (Exception e) {
            logger.error("Error saveUserLogin() " + e.getMessage());
            throw new ApplicationException("Error saveUserLogin() " + e.getMessage());

        } finally {

        }
        return userLoginList;

    }

    private long getMaxUserLoginKey(ElegantUserLogin user) throws ApplicationException {
        Long userLoginId = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getMaxUserLoginKey");
            query.setParameter(0, user.getCompID());
            query.setParameter(1, user.getUserID());
            userLoginId = (Long) query.list().get(0);
        } catch (Exception e) {
            logger.error("getMaxUserLoginKey() " + e.getMessage());
            throw new ApplicationException("getMaxUserLoginKey() " + e.getMessage());
        }
        return userLoginId;
    }

    @Override
    public ElegantHitCounter getHitCount(ElegantHitCounter counter) throws ApplicationException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getHitCount");
            query.setParameter(0, counter.getHitID());
            counter = (ElegantHitCounter) query.list().get(0);
        } catch (Exception e) {
            logger.error("getHitCount() " + e.getMessage());
            throw new ApplicationException("getHitCount() " + e.getMessage());
        }
        return counter;

    }

    @Override
    public ElegantHitCounter saveHitCount(ElegantHitCounter counter) throws ApplicationException {
        if (counter.getHitID() == 0) {
            logger.error("saveHitCount() Hit Id cannot be zero");
            throw new ApplicationException("saveHitCount() Hit Id cannot be zero");
        }

        try {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(counter);
        } catch (Exception e) {
            logger.error("Error saveHitCount() " + e.getMessage());
            throw new ApplicationException("Error saveHitCount() " + e.getMessage());

        } finally {

        }
        return counter;

    }

    /**
     * @return the elegantClientsAndUpdates
     */
    public ElegantClientsAndUpdates getElegantClientsAndUpdates() {
        return elegantClientsAndUpdates;
    }

    /**
     * @param elegantClientsAndUpdates the elegantClientsAndUpdates to set
     */
    public void setElegantClientsAndUpdates(ElegantClientsAndUpdates elegantClientsAndUpdates) {
        this.elegantClientsAndUpdates = elegantClientsAndUpdates;
    }

    @Override
    public ArrayList<ElegantUser> saveUserGenPassword(ArrayList<ElegantUser> userList) throws ApplicationException {
        try {
            Session session = sessionFactory.getCurrentSession();
            for (ElegantUser user : userList) {
                long no = System.currentTimeMillis();
                String str = Long.toString(no);
                byte[] encoded = Base64.getEncoder().encode(str.substring(7).getBytes());
                String s = new String(encoded);
                user.setUserLoginPwd(s);
                if (sendEmailToUserWithPwd(user, user.getEmailId())) {
                    session.saveOrUpdate(user);
                    if (logger.isDebugEnabled()) {
                        logger.debug("created password " + user.getEmailId());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error saveUserActivation() " + e.getMessage());
            throw new ApplicationException("Error saveUserActivation() " + e.getMessage());

        } finally {

        }
        return userList;

    }

    @Override
    public ElegantUser getLoginByUserNameOrEmail(String userName) throws ApplicationException {
        ElegantUser elegantUser = null;
        if (userName.equals("")) {
            return elegantUser;
        }
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("getUserByNameOrEmail");
            query.setParameter(0, userName);
            query.setParameter(1, userName);
            if (!query.list().isEmpty()) {
                elegantUser = (ElegantUser) query.list().get(0);
            }
            if (elegantUser != null && logger.isDebugEnabled()) {
                logger.debug("getLoginByUserNameOrEmail() " + elegantUser.getCompID() + "- " + elegantUser.getUserID());
            }

        } catch (Exception e) {
            logger.error("Error getLoginByUserNameOrEmail() " + e.getMessage());
            throw new ApplicationException("Error getLoginByUserNameOrEmail() "
                    + e.getMessage());
        }

        return elegantUser;

    }

}
