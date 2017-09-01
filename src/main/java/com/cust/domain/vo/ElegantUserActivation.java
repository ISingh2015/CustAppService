package com.cust.domain.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserActivation")
public class ElegantUserActivation implements Serializable, Comparable<ElegantUserActivation> {

    private static final long serialVersionUID = 4173435938575881525L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @Column(name = "compId")
    private long compID;

    @Id
    @Column(name = "userId")
    private long userID;

    @Column(name = "activationCode")
    private String userActivation;


    public int compareTo(ElegantUserActivation o) {
        if (o == null) {
            return 0;
        }
        if (this.getUserID() < o.getUserID()) {
            return 1;
        } else if (this.getUserID() > o.getUserID()) {
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
     * @return the userActivation
     */
    public String getUserActivation() {
        return userActivation;
    }

    /**
     * @param userActivation the userActivation to set
     */
    public void setUserActivation(String userActivation) {
        this.userActivation = userActivation;
    }

}
