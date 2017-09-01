/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.vo;

import java.io.Serializable;

/**
 *
 * @author ISanhot
 */
public class ElegantClientsAndUpdates implements Serializable {

    private int clientCount, updateCount;

    /**
     * @return the clientCount
     */
    public int getClientCount() {
        return clientCount;
    }

    /**
     * @param clientCount the clientCount to set
     */
    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
        System.out.println("Setting-Resetting Total Clients " + this.clientCount);        
    }

    /**
     * @return the updateCount
     */
    public int getUpdateCount() {
        return updateCount;
    }

    /**
     * @param updateCount the updateCount to set
     */
    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

}
