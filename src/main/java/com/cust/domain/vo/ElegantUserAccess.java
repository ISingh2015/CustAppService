package com.cust.domain.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserAppAccess")
public class ElegantUserAccess implements Serializable, Comparable<ElegantUserAccess> {

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

    @Id
    @Column(name = "accessId")
    private long userAccessId;

    @Column(name = "menuId")
    private Integer menuId;

    @Column(name = "menuAllowed")
    private boolean menuAllowed;

    public int compareTo(ElegantUserAccess o) {
        if (o == null) {
            return 0;
        }
        if (this.getUserAccessId() < o.getUserAccessId()) {
            return 1;
        } else if (this.getUserAccessId() > o.getUserAccessId()) {
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
     * @return the userAccessId
     */
    public long getUserAccessId() {
        return userAccessId;
    }

    /**
     * @param userAccessId the userAccessId to set
     */
    public void setUserAccessId(long userAccessId) {
        this.userAccessId = userAccessId;
    }

    /**
     * @return the menuId
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * @param menuId the menuId to set
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * @return the menuAllowed
     */
    public boolean getMenuAllowed() {
        return menuAllowed;
    }

    /**
     * @param menuAllowed the menuAllowed to set
     */
    public void setMenuAllowed(boolean menuAllowed) {
        this.menuAllowed = menuAllowed;
    }

}
