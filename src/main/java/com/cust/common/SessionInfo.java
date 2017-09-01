package com.cust.common;

import java.io.Serializable;

/**
 * This contains all the details associated with a Session. It will contain the
 * user details also.
 *
 * @author Inderjit
 */
public class SessionInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private UserInfo userInfo;
    private String sessionId;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
