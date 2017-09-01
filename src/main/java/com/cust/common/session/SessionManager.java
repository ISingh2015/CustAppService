package com.cust.common.session;

import com.cust.common.SessionInfo;
import java.io.Serializable;

public class SessionManager implements Serializable {

    private static final long serialVersionUID = 1L;


    public boolean validateSession(SessionInfo sessionInfo) {
        if (sessionInfo == null || sessionInfo.getUserInfo() == null) {
            return false;
        }
        return true;
    }

    public boolean validateUser(SessionInfo sessionInfo) {
        if (sessionInfo != null && sessionInfo.getUserInfo() != null && (sessionInfo.getUserInfo().getUserName() == null || sessionInfo.getUserInfo().getUserName() == "")) {
            return false;
        }
        return true;
    }

    public boolean invalidateSession(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return true;
        }
        return true;
    }


}
