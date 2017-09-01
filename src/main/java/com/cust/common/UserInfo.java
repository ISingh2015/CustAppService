package com.cust.common;

import java.io.Serializable;

/**
 * This will have all the information for the current logged on user.
 *
 * @author Inderjit
 */

public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    private String userName, loginId, loginPassword, loginDate, loginIp;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * @return the loginPassword
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * @param loginPassword the loginPassword to set
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * @return the loginDate
     */
    public String getLoginDate() {
        return loginDate;
    }

    /**
     * @param loginDate the loginDate to set
     */
    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * @return the loginIp
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * @param loginIp the loginIp to set
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

}
