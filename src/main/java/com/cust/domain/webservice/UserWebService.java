package com.cust.domain.webservice;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.common.ServicePayload;
import com.cust.domain.vo.ElegantHitCounter;
import com.cust.domain.vo.ElegantUser;
import com.cust.domain.vo.ElegantUserActivation;
import com.cust.domain.vo.ElegantUserLogin;

public interface UserWebService {

    public ServicePayload getLoginByUserNameAndPassword(ServiceControl serviceControl, String userName, String password) throws ApplicationException;

    public ServicePayload getLoginByUserNameOrEmail(ServiceControl serviceControl, String userName) throws ApplicationException;

    public ServicePayload getUserById(ServiceControl serviceControl, long compId, long Id) throws ApplicationException;

    public ServicePayload getAllUsers(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ServicePayload getUserByCriteria(ServiceControl serviceControl) throws ApplicationException;

    public ServicePayload saveUserList(ServiceControl serviceControl, ArrayList<ElegantUser> userList, boolean createAccessRights) throws ApplicationException;

    public ServicePayload saveUserActivation(ServiceControl serviceControl, ArrayList<ElegantUserActivation> userList, String mailTo) throws ApplicationException;

    public ServicePayload saveUserGenPassword(ServiceControl serviceControl, ArrayList<ElegantUser> userList) throws ApplicationException;

    public ServicePayload deleteUserList(ServiceControl serviceControl, ArrayList<ElegantUser> userList) throws ApplicationException;

    public ServicePayload saveUserLoginList(ServiceControl serviceControl, ArrayList<ElegantUserLogin> userLoginList) throws ApplicationException;

    public ServicePayload getHitCount(ServiceControl serviceControl, ElegantHitCounter counter) throws ApplicationException;

    public ServicePayload saveHitCount(ServiceControl serviceControl, ElegantHitCounter counter) throws ApplicationException;

}
