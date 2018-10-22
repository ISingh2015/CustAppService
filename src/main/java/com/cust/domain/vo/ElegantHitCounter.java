package com.cust.domain.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WebSiteHitCount")
public class ElegantHitCounter implements Serializable {

    private static final long serialVersionUID = 4173435938575881525L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @Column(name = "hitId")
    private long hitID;

    @Column(name = "hitCount")
    private long hitCounter;

    /**
     * @return the hitID
     */
    public long getHitID() {
        return hitID;
    }

    /**
     * @param hitID the hitID to set
     */
    public void setHitID(long hitID) {
        this.hitID = hitID;
    }

    /**
     * @return the hitCounter
     */
    public long getHitCounter() {
        return hitCounter;
    }

    /**
     * @param hitCounter the hitCounter to set
     */
    public void setHitCounter(long hitCounter) {
        this.hitCounter = hitCounter;
    }
}
