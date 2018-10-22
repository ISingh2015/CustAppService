/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.common.session;

import java.util.Hashtable;

/**
 *
 * @author ISanhot
 */
public class UserSessionManager {
    private Hashtable<String,String> userSessionList = new Hashtable<String, String> ();

    /**
     * @return the userSessionList
     */
    public Hashtable<String,String> getUserSessionList() {
        return userSessionList;
    }


}
