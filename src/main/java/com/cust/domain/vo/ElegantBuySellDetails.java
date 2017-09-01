/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.vo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.envers.Audited;

/**
 *
 * @author Inderjit
 */
@Entity
@Table(name = "BuySellDetails")
public class ElegantBuySellDetails implements Serializable, Comparable<ElegantBuySellDetails> {

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
    @Column(name = "billId")
    private long billID;

    @Id
    @Column(name = "srl")
    private long srl;

    @Column(name = "productId")
    private long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "purchqty")
    private Double purchQty = 0d;

    @Column(name = "purchRtnqty")
    private Double purchRtnQty = 0d;

    @Column(name = "purchRate")
    private Double purchRate = 0d;

    @Column(name = "billedqty")
    private Double billedQty = 0d;

    @Column(name = "billedRtnqty")
    private Double billedRtnQty = 0d;

    @Column(name = "billedRate")
    private Double billedRate = 0d;

    @Column(name = "unitPackaging")
    private String unitPackaging;

    @Column(name = "unitDiscount")
    private Double unitDiscount = 0d;

    @Column(name = "unitAmt")
    private Double unitAmt = 0d;

    @Transient
    private Double inStock=0d;

    @Override
    public int compareTo(ElegantBuySellDetails o) {
        if (o == null) {
            return 0;
        }
        if (this.getBillID() < o.getBillID()) {
            return 1;
        } else if (this.getBillID() > o.getBillID()) {
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
     * @return the billID
     */
    public long getBillID() {
        return billID;
    }

    /**
     * @param billID the billID to set
     */
    public void setBillID(long billID) {
        this.billID = billID;
    }

    /**
     * @return the srl
     */
    public long getSrl() {
        return srl;
    }

    /**
     * @param srl the srl to set
     */
    public void setSrl(long srl) {
        this.srl = srl;
    }

    /**
     * @return the unitPackaging
     */
    public String getUnitPackaging() {
        return unitPackaging;
    }

    /**
     * @param unitPackaging the unitPackaging to set
     */
    public void setUnitPackaging(String unitPackaging) {
        this.unitPackaging = unitPackaging;
    }

    /**
     * @return the unitAmt
     */
    public Double getUnitAmt() {
        return unitAmt;
    }

    /**
     * @param unitAmt the unitAmt to set
     */
    public void setUnitAmt(Double unitAmt) {
        this.unitAmt = unitAmt;
    }

    /**
     * @return the productId
     */
    public long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }

    /**
     * @return the unitDiscount
     */
    public Double getUnitDiscount() {
        return unitDiscount;
    }

    /**
     * @param unitDiscount the unitDiscount to set
     */
    public void setUnitDiscount(Double unitDiscount) {
        this.unitDiscount = unitDiscount;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the purchQty
     */
    public Double getPurchQty() {
        return purchQty;
    }

    /**
     * @param purchQty the purchQty to set
     */
    public void setPurchQty(Double purchQty) {
        this.purchQty = purchQty;
    }

    /**
     * @return the purchRtnQty
     */
    public Double getPurchRtnQty() {
        return purchRtnQty;
    }

    /**
     * @param purchRtnQty the purchRtnQty to set
     */
    public void setPurchRtnQty(Double purchRtnQty) {
        this.purchRtnQty = purchRtnQty;
    }

    /**
     * @return the purchRate
     */
    public Double getPurchRate() {
        return purchRate;
    }

    /**
     * @param purchRate the purchRate to set
     */
    public void setPurchRate(Double purchRate) {
        this.purchRate = purchRate;
    }

    /**
     * @return the billedQty
     */
    public Double getBilledQty() {
        return billedQty;
    }

    /**
     * @param billedQty the billedQty to set
     */
    public void setBilledQty(Double billedQty) {
        this.billedQty = billedQty;
    }

    /**
     * @return the billedRtnQty
     */
    public Double getBilledRtnQty() {
        return billedRtnQty;
    }

    /**
     * @param billedRtnQty the billedRtnQty to set
     */
    public void setBilledRtnQty(Double billedRtnQty) {
        this.billedRtnQty = billedRtnQty;
    }

    /**
     * @return the billedRate
     */
    public Double getBilledRate() {
        return billedRate;
    }

    /**
     * @param billedRate the billedRate to set
     */
    public void setBilledRate(Double billedRate) {
        this.billedRate = billedRate;
    }
    /**
     * @return the inStock
     */
    public Double getInStock() {
        return inStock;
    }

    /**
     * @param inStock the inStock to set
     */
    public void setInStock(Double inStock) {
        this.inStock = inStock;
    }


}
