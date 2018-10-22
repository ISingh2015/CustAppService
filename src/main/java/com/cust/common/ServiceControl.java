package com.cust.common;

import java.io.Serializable;
/**
 * 
 * @author Inderjit
 */
public class ServiceControl implements Serializable {

    private static final long serialVersionUID = 1L;
    private Pagination pagination;
    private DBInfo dbInfo;
    private SessionInfo sessionInfo;
    private QueryCriteria queryCriteria;

    /**
     * @return the queryCriteria
     */
    public QueryCriteria getQueryCriteria() {
        return queryCriteria;
    }

    /**
     * @param queryCriteria the queryCriteria to set
     */
    public void setQueryCriteria(QueryCriteria queryCriteria) {
        this.queryCriteria = queryCriteria;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * @return the dbInfo
     */
    public DBInfo getDbInfo() {
        return dbInfo;
    }

    /**
     * @param dbInfo the dbInfo to set
     */
    public void setDbInfo(DBInfo dbInfo) {
        this.dbInfo = dbInfo;
    }

    /**
     * @return the sessionInfo
     */
    public SessionInfo getSessionInfo() {
        return sessionInfo;
    }

    /**
     * @param sessionInfo the sessionInfo to set
     */
    public void setSessionInfo(SessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

}
