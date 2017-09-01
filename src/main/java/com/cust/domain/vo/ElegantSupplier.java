package com.cust.domain.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "Supplier")
public class ElegantSupplier implements Serializable, Comparable<ElegantSupplier> {

    private static final long serialVersionUID = 4173435938575881525L;

    @Id
    @Column(name = "compId")
    private long compID;

    @Id
    @Column(name = "userId")
    private long userID;

    @Id
    @Column(name = "supId")
    private long supID;

    @Column(name = "website")
    private String webSite;

    @Column(name = "linkedin")
    private String linkeInAccount;

    @Column(name = "facebook")
    private String faceBookAccount;

    @Column(name = "twitter")
    private String twitterAccount;

    @Column(name = "supName")
    private String supName;

    @Column(name = "addressess")
    private String addressesXML;

    @Column(name = "paymentTerms")
    private Integer paymentTerms = 30;

    @Column(name = "creditLimit")
    private Double creditLimit = 100000d;

    @Column(name = "frozen")
    private Integer frozen;

    @Column(name = "createDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createDate;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getLinkeInAccount() {
        return linkeInAccount;
    }

    public void setLinkeInAccount(String linkeInAccount) {
        this.linkeInAccount = linkeInAccount;
    }

    public String getFaceBookAccount() {
        return faceBookAccount;
    }

    public void setFaceBookAccount(String faceBookAccount) {
        this.faceBookAccount = faceBookAccount;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    public String getAddressesXML() {
        return addressesXML;
    }

    public void setAddressesXML(String addressesXML) {
        this.addressesXML = addressesXML;
    }

    public Integer getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(Integer paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
     * @param supID the supID to set
     */
    public void setSupID(long supID) {
        this.supID = supID;
    }

    /**
     * @return the supID
     */
    public long getSupID() {
        return supID;
    }

    /**
     * @return the supName
     */
    public String getSupName() {
        return supName;
    }

    /**
     * @param supName the supName to set
     */
    public void setSupName(String supName) {
        this.supName = supName;
    }

    @Override
    public int compareTo(ElegantSupplier o) {
        if (o == null) {
            return 0;
        }
        if (this.getSupID() < o.getSupID()) {
            return 1;
        } else if (this.getSupID() > o.getSupID()) {
            return -1;
        }
        return 0;
    }

}
