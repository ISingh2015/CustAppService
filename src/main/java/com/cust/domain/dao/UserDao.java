package com.cust.domain.dao;

import java.util.ArrayList;
import com.cust.common.ApplicationException;
import com.cust.common.ServiceControl;
import com.cust.domain.vo.ElegantHitCounter;
import com.cust.domain.vo.ElegantUser;
import com.cust.domain.vo.ElegantUserActivation;
import com.cust.domain.vo.ElegantUserLogin;

/**
 *
 * @author Inderjit
 */
public interface UserDao {

    public ElegantUser getLoginByUserNameAndPassword(String userName, String password) throws ApplicationException;

    public ElegantUser getLoginByUserNameOrEmail(String userName) throws ApplicationException;

    public ElegantUser getUserById(long conpId, long Id) throws ApplicationException;

    public ArrayList<ElegantUser> getAllUsers(ServiceControl serviceControl, long compId) throws ApplicationException;

    public ArrayList<ElegantUser> getUserByCriteria(ServiceControl serviceControl) throws ApplicationException;

    public ArrayList<ElegantUser> saveUserList(ArrayList<ElegantUser> userList, boolean createAccessRights) throws ApplicationException;

    public ArrayList<ElegantUserActivation> saveUserActivation(ArrayList<ElegantUserActivation> userList, String mailTo) throws ApplicationException;

    public ArrayList<ElegantUser> saveUserGenPassword(ArrayList<ElegantUser> userList) throws ApplicationException;

    public Boolean deleteUserList(ArrayList<ElegantUser> userList) throws ApplicationException;

    public ArrayList<ElegantUserLogin> saveUserLogin(ArrayList<ElegantUserLogin> userLoginList) throws ApplicationException;

    public ElegantHitCounter getHitCount(ElegantHitCounter counter) throws ApplicationException;

    public ElegantHitCounter saveHitCount(ElegantHitCounter counter) throws ApplicationException;

}
