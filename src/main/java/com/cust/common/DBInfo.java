package com.cust.common;

import com.cust.common.session.*;
import java.io.Serializable;
import java.util.Map;

/**
 * This will contain all the details that are required for setting a Data
 * Source.
 */
public class DBInfo implements Serializable {

    public static final String defaultDB = "DEFAULT";
    private static final long serialVersionUID = 1L;
    private String dbName;
    private Map<Object, Object> targetDataSources;

    public String getDbName() {
        return dbName;
    }

    public Map<Object, Object> getTargetDataSources() {
        return targetDataSources;
    }

    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        this.targetDataSources = targetDataSources;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

}
