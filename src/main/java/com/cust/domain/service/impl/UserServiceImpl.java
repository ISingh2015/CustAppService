package com.cust.domain.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cust.common.ApplicationException;
import com.cust.common.ResponseMetaData;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.dao.UserDao;
import com.cust.domain.service.PreferenceService;
import com.cust.domain.service.UserService;
import com.cust.domain.vo.ElegantHitCounter;
import com.cust.domain.vo.ElegantUser;
import com.cust.domain.vo.ElegantUserActivation;
import com.cust.domain.vo.ElegantUserLogin;
import com.cust.domain.vo.PreferenceVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao elegantUserDao;
//    @Autowired
//    private UserSessionManager userSessionManager;

    @Autowired
    private PreferenceService elegantPreferenceDao;

    @Override
    public ServicePayload getLoginByUserNameAndPassword(ServiceControl serviceControl, String userName, String password) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantUser elegantUser = null;
        elegantUser = elegantUserDao.getLoginByUserNameAndPassword(userName, password);
        List<Object> objectList = new ArrayList<Object>();
        if (elegantUser != null) {
            objectList.add(elegantUser);

            ArrayList<PreferenceVO> preferenceVOList = elegantPreferenceDao.getServiceNames(serviceControl, elegantUser.getCompID());
            objectList.add(preferenceVOList);
        }
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload getUserById(ServiceControl serviceControl, long compId, long id) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantUser elegantUser = null;
        elegantUser = elegantUserDao.getUserById(compId, id);
        List<Object> objectList = new ArrayList<Object>();
        objectList.add(elegantUser);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);

        return servicePayload;

    }

    @Override
    public ServicePayload getAllUsers(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantUser> elegantUserList = null;
        elegantUserList = elegantUserDao.getAllUsers(serviceControl, compId);
        List<Object> objectList = new ArrayList<Object>();
        objectList.add(elegantUserList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);

        return servicePayload;

    }

    @Override
    public ServicePayload saveUserList(ServiceControl serviceControl, ArrayList<ElegantUser> userList, boolean createAccessRights) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        userList = elegantUserDao.saveUserList(userList, createAccessRights);
        List<Object> objectList = new ArrayList<Object>();
        objectList.add(userList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);

        return servicePayload;

    }

    @Override
    public ServicePayload deleteUserList(ServiceControl serviceControl, ArrayList<ElegantUser> userList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        Boolean deleted = false;
        deleted = elegantUserDao.deleteUserList(userList);
        List<Object> objectList = new ArrayList<Object>();
        objectList.add(deleted);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);

        return servicePayload;
    }

    @Override
    public ServicePayload getUserByCriteria(ServiceControl serviceControl) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantUser> elegantUserList = null;
        elegantUserList = elegantUserDao.getUserByCriteria(serviceControl);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantUserList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);

        return servicePayload;

    }

    @Override
    public ServicePayload saveUserActivation(ServiceControl serviceControl, ArrayList<ElegantUserActivation> userList, String mailTo) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantUserActivation> elegantUserList = null;
        elegantUserList = elegantUserDao.saveUserActivation(userList, mailTo);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantUserList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);

        return servicePayload;

    }


    @Override
    public ServicePayload saveUserLoginList(ServiceControl serviceControl, ArrayList<ElegantUserLogin> userLoginList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        userLoginList = elegantUserDao.saveUserLogin(userLoginList);
        List<Object> objectList = new ArrayList<>();
        objectList.add(userLoginList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);

        return servicePayload;

    }
    @Override
    public ServicePayload getHitCount(ServiceControl serviceControl, ElegantHitCounter counter) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantHitCounter elegantHitCounter = null;
        elegantHitCounter = elegantUserDao.getHitCount(counter);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantHitCounter);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        
        return servicePayload;

    }

    @Override
    public ServicePayload saveHitCount(ServiceControl serviceControl, ElegantHitCounter counter) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantHitCounter elegantHitCounter = null;
        elegantHitCounter = elegantUserDao.saveHitCount(counter);
        List<Object> objectList = new ArrayList<>();
        objectList.add(elegantHitCounter);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);

        return servicePayload;

    }

    @Override
    public ServicePayload saveUserGenPassword(ServiceControl serviceControl, ArrayList<ElegantUser> userList) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ArrayList<ElegantUser> elegantUserList = null;
        elegantUserList = elegantUserDao.saveUserGenPassword(userList);
        List<Object> objectList = new ArrayList<Object>();
        objectList.add(elegantUserList);
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

    @Override
    public ServicePayload getLoginByUserNameOrEmail(ServiceControl serviceControl, String userName) throws ApplicationException {
        ServicePayload servicePayload = new ServicePayload();
        ElegantUser elegantUser = null;
        elegantUser = elegantUserDao.getLoginByUserNameOrEmail(userName);
        List<Object> objectList = new ArrayList<>();
        if (elegantUser != null) {
            objectList.add(elegantUser);
        }
        servicePayload.setResponseValue(objectList);
        ResponseMetaData responseMetaData = new ResponseMetaData();
        responseMetaData.setQueryCriteria(serviceControl.getQueryCriteria());
        servicePayload.setReponseMetaData(responseMetaData);
        return servicePayload;

    }

}
