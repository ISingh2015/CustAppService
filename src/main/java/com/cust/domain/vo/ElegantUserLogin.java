package com.cust.domain.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserLogins")
public class ElegantUserLogin implements Serializable, Comparable<ElegantUserLogin> {

    private static long serialVersionUID = 4173435938575881525L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @Column(name = "compId")
    private long compID;

    @Id
    @Column(name = "userId")
    private long userID;

    @Id
    @Column(name = "loginid")
    private long userLoginId;

    @Column(name = "loginIP")
    private String loginIP;

    @Column(name = "loginDt")
    private Date loginDate;

    public int compareTo(ElegantUserLogin o) {
        if (o == null) {
            return 0;
        }
        if (this.getUserLoginId() < o.getUserLoginId()) {
            return 1;
        } else if (this.getUserLoginId() > o.getUserLoginId()) {
            return -1;
        }
        return 0;
    }

    /**
     * @return the compID
     */
    public long getCompID() {
        return compID;
    }

    /**
     * @param compID the compID to set
     */
    public void setCompID(long compID) {
        this.compID = compID;
    }

    /**
     * @return the userID
     */
    public long getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(long userID) {
        this.userID = userID;
    }

    /**
     * @return the userLoginId
     */
    public long getUserLoginId() {
        return userLoginId;
    }

    /**
     * @param userLoginId the userLoginId to set
     */
    public void setUserLoginId(long userLoginId) {
        this.userLoginId = userLoginId;
    }

    /**
     * @return the loginIP
     */
    public String getLoginIP() {
        return loginIP;
    }

    /**
     * @param loginIP the loginIP to set
     */
    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    /**
     * @return the loginDate
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * @param loginDate the loginDate to set
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

}
