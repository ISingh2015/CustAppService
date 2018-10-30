package com.cust.domain.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import org.hibernate.envers.Audited;

@Entity
@Table(name = "SalesMan")
public class ElegantSalesMan implements Serializable, Comparable<ElegantSalesMan> {

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

    @Column(name = "userId")
    private long userID;

    @Id
    @Column(name = "salesManId")
    private long salesManID;

    @Column(name = "name")
    private String salesManName;

    @Column(name = "managerId")
    private Long managerId = 0l;

    @Column(name = "quota1stqtr")
    private Double firstQtr = 0d;

    @Column(name = "quota2ndqtr")
    private Double secondQtr= 0d;
    
    @Column(name = "quota3rdqtr")
    private Double thirdQtr = 0d;
    
    @Column(name = "quota4thqtr")
    private Double fourthQtr = 0d;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "frozen")
    private Integer frozen;

    @Override
    public int compareTo(ElegantSalesMan o) {
        if (o == null) {
            return 0;
        }
        if (this.getSalesManID() < o.getSalesManID()) {
            return 1;
        } else if (this.getSalesManID() > o.getSalesManID()) {
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
     * @return the salesManID
     */
    public long getSalesManID() {
        return salesManID;
    }

    /**
     * @param salesManID the salesManID to set
     */
    public void setSalesManID(long salesManID) {
        this.salesManID = salesManID;
    }

    /**
     * @return the salesManName
     */
    public String getSalesManName() {
        return salesManName;
    }

    /**
     * @param salesManName the salesManName to set
     */
    public void setSalesManName(String salesManName) {
        this.salesManName = salesManName;
    }

    /**
     * @return the managerId
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * @param managerId the managerId to set
     */
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the frozen
     */
    public Integer getFrozen() {
        return frozen;
    }

    /**
     * @param frozen the frozen to set
     */
    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    /**
     * @return the firstQtr
     */
    public Double getFirstQtr() {
        return firstQtr;
    }

    /**
     * @param firstQtr the firstQtr to set
     */
    public void setFirstQtr(Double firstQtr) {
        this.firstQtr = firstQtr;
    }

    /**
     * @return the secondQtrr
     */
    public Double getSecondQtr() {
        return secondQtr;
    }

    /**
     * @param secondQtrr the secondQtrr to set
     */
    public void setSecondQtr(Double secondQtr) {
        this.secondQtr = secondQtr;
    }

    /**
     * @return the thirdQtr
     */
    public Double getThirdQtr() {
        return thirdQtr;
    }

    /**
     * @param thirdQtr the thirdQtr to set
     */
    public void setThirdQtr(Double thirdQtr) {
        this.thirdQtr = thirdQtr;
    }

    /**
     * @return the fourthQtr
     */
    public Double getFourthQtr() {
        return fourthQtr;
    }

    /**
     * @param fourthQtr the fourthQtr to set
     */
    public void setFourthQtr(Double fourthQtr) {
        this.fourthQtr = fourthQtr;
    }


}
