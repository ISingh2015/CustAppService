package com.cust.domain.webservice.impl;

import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.service.UserService;
import com.cust.domain.vo.ElegantHitCounter;
import com.cust.domain.vo.ElegantUser;
import com.cust.domain.vo.ElegantUserActivation;
import com.cust.domain.vo.ElegantUserLogin;
import com.cust.domain.webservice.UserWebService;
import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Inderjit
 */
public class UserWebServiceImpl implements UserWebService, Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserService elegantUserService;

    @Override
    public ServicePayload getLoginByUserNameAndPassword(ServiceControl serviceControl, String userName, String password) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.getLoginByUserNameAndPassword(serviceControl, userName, password);
        return servicePayload;
    }

    @Override
    public ServicePayload getUserById(ServiceControl serviceControl, long compId, long Id) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.getUserById(serviceControl, compId, Id);
        return servicePayload;
    }

    @Override
    public ServicePayload getAllUsers(ServiceControl serviceControl, long compId) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.getAllUsers(serviceControl, compId);
        return servicePayload;
    }

    @Override
    public ServicePayload saveUserList(ServiceControl serviceControl, ArrayList<ElegantUser> userList, boolean createAccessRights) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.saveUserList(serviceControl, userList, createAccessRights);
        return servicePayload;
    }

    @Override
    public ServicePayload deleteUserList(ServiceControl serviceControl, ArrayList<ElegantUser> userList) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.deleteUserList(serviceControl, userList);
        return servicePayload;
    }

    @Override
    public ServicePayload getUserByCriteria(ServiceControl serviceControl) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.getUserByCriteria(serviceControl);
        return servicePayload;

    }

    @Override
    public ServicePayload saveUserActivation(ServiceControl serviceControl, ArrayList<ElegantUserActivation> userList, String mailTo) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.saveUserActivation(serviceControl, userList, mailTo);
        return servicePayload;
    }

    @Override
    public ServicePayload saveUserLoginList(ServiceControl serviceControl, ArrayList<ElegantUserLogin> userLoginList) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.saveUserLoginList(serviceControl, userLoginList);
        return servicePayload;

    }

    @Override
    public ServicePayload getHitCount(ServiceControl serviceControl, ElegantHitCounter counter) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.getHitCount(serviceControl, counter);
        return servicePayload;

    }

    @Override
    public ServicePayload saveHitCount(ServiceControl serviceControl, ElegantHitCounter counter) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.saveHitCount(serviceControl, counter);
        return servicePayload;

    }

    @Override
    public ServicePayload saveUserGenPassword(ServiceControl serviceControl, ArrayList<ElegantUser> userList) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.saveUserGenPassword(serviceControl, userList);
        return servicePayload;

    }

    @Override
    public ServicePayload getLoginByUserNameOrEmail(ServiceControl serviceControl, String userName) throws ApplicationException {
        ServicePayload servicePayload = elegantUserService.getLoginByUserNameOrEmail(serviceControl, userName);
        return servicePayload;

    }

}
