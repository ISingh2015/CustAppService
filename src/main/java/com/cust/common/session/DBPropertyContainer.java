package com.cust.common.session;

import com.cust.common.*;

/* Author Inderjit */
public class DBPropertyContainer {

    private String dbUserName;
    private String dbPassword;
    private String dbServerName;
    private String dbServerPort;
    private String dbDriverClassName;
    private String buyProperty;
    private String sellProperty;

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbServerName() {
        return dbServerName;
    }

    public void setDbServerName(String dbServerName) {
        this.dbServerName = dbServerName;
    }

    public String getDbServerPort() {
        return dbServerPort;
    }

    public void setDbServerPort(String dbServerPort) {
        this.dbServerPort = dbServerPort;
    }

    /**
     * @return the dbDriverClassName
     */
    public String getDbDriverClassName() {
        return dbDriverClassName;
    }

    /**
     * @param dbDriverClassName the dbDriverClassName to set
     */
    public void setDbDriverClassName(String dbDriverClassName) {
        this.dbDriverClassName = dbDriverClassName;
    }

    /**
     * @return the buyProperty
     */
    public String getBuyProperty() {
        return buyProperty;
    }

    /**
     * @param buyProperty the buyProperty to set
     */
    public void setBuyProperty(String buyProperty) {
        this.buyProperty = buyProperty;
    }

    /**
     * @return the sellProperty
     */
    public String getSellProperty() {
        return sellProperty;
    }

    /**
     * @param sellProperty the sellProperty to set
     */
    public void setSellProperty(String sellProperty) {
        this.sellProperty = sellProperty;
    }

}
