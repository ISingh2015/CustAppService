/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Inderjit
 */
@Entity
@Table(name = "BuySell")
public class ElegantBuySell implements Serializable, Comparable<ElegantBuySell> {

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

    @Column(name = "userId")
    private long userID;

    @Id
    @Column(name = "billId")
    private long billID = 0;

    @Column(name = "billType")
    private Integer billType = 0;

    @Column(name = "billNo")
    private String billNo;

    @Column(name = "billDate")
    private Date billDt;

    @Column(name = "buyerSellerCode")
    private Integer buyerSellerCode = 0;

    @Column(name = "buyerSellerName")
    private String buyerSellerName;

    @Column(name = "buyerSellerBillNo")
    private String buyerSellBillNo;

    @Column(name = "buyerSellerBillDt")
    private Date buyerSellerBillDt;

    @Column(name = "salesManCode")
    private Integer salesManCode = 0;

    @Column(name = "salesManName")
    private String salesManName;

    @Column(name = "freightTranspDedAmt")
    private Double freighTranspDedAmt = 0d;

    @Column(name = "taxDedAmt")
    private Double taxDedAmt = 0d;

    @Column(name = "finalBillAmt")
    private Double finalBillAmt = 0d;

    @Column(name = "AdjAmt")
    private Double AdjAmt = 0d;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "billStatus")
    private Integer billStatus;

    @Column(name = "authReq")
    private Integer authRequired;

    @Column(name = "authStatus")
    private Integer authStatus;

    @Column(name = "authDate")
    private Date authDate;

    @Column(name = "authRemarks")
    private String authRemarks;

    @Column(name = "stockPosted")
    private Integer stockPosted=0;

    @Transient
    private ArrayList<ElegantBuySellDetails> buySellDetailsList;

    @Override
    public int compareTo(ElegantBuySell o) {
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
     * @return the billType
     */
    public Integer getBillType() {
        return billType;
    }

    /**
     * @param billType the billType to set
     */
    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    /**
     * @return the buyerSellerCode
     */
    public Integer getBuyerSellerCode() {
        return buyerSellerCode;
    }

    /**
     * @param buyerSellerCode the buyerSellerCode to set
     */
    public void setBuyerSellerCode(Integer buyerSellerCode) {
        this.buyerSellerCode = buyerSellerCode;
    }

    /**
     * @return the billNo
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * @param billNo the billNo to set
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    /**
     * @return the billDt
     */
    public Date getBillDt() {
        if (this.billDt == null) {
            setBillDt(new Date());
        }
        return this.billDt;
    }

    /**
     * @param billDt the billDt to set
     */
    public void setBillDt(Date billDt) {
        this.billDt = billDt;
    }

    /**
     * @return the salesManCode
     */
    public Integer getSalesManCode() {
        return salesManCode;
    }

    /**
     * @param salesManCode the salesManCode to set
     */
    public void setSalesManCode(Integer salesManCode) {
        this.salesManCode = salesManCode;
    }

    /**
     * @return the freighTranspDedAmt
     */
    public Double getFreighTranspDedAmt() {
        return freighTranspDedAmt;
    }

    /**
     * @param freighTranspDedAmt the freighTranspDedAmt to set
     */
    public void setFreighTranspDedAmt(Double freighTranspDedAmt) {
        this.freighTranspDedAmt = freighTranspDedAmt;
    }

    /**
     * @return the taxDedAmt
     */
    public Double getTaxDedAmt() {
        return taxDedAmt;
    }

    /**
     * @param taxDedAmt the taxDedAmt to set
     */
    public void setTaxDedAmt(Double taxDedAmt) {
        this.taxDedAmt = taxDedAmt;
    }

    /**
     * @return the finalBillAmt
     */
    public Double getFinalBillAmt() {
        return finalBillAmt;
    }

    /**
     * @param finalBillAmt the finalBillAmt to set
     */
    public void setFinalBillAmt(Double finalBillAmt) {
        this.finalBillAmt = finalBillAmt;
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
     * @return the billStatus
     */
    public Integer getBillStatus() {
        return billStatus;
    }

    /**
     * @param billStatus the billStatus to set
     */
    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    /**
     * @return the buySellDetailsList
     */
    public ArrayList<ElegantBuySellDetails> getBuySellDetailsList() {
        return buySellDetailsList;
    }

    /**
     * @param buySellDetailsList the buySellDetailsList to set
     */
    public void setBuySellDetailsList(ArrayList<ElegantBuySellDetails> buySellDetailsList) {
        this.buySellDetailsList = buySellDetailsList;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return the buyerSellBillNo
     */
    public String getBuyerSellBillNo() {
        return buyerSellBillNo;
    }

    /**
     * @param buyerSellBillNo the buyerSellBillNo to set
     */
    public void setBuyerSellBillNo(String buyerSellBillNo) {
        this.buyerSellBillNo = buyerSellBillNo;
    }

    /**
     * @return the AdjAmt
     */
    public Double getAdjAmt() {
        return AdjAmt;
    }

    /**
     * @param AdjAmt the AdjAmt to set
     */
    public void setAdjAmt(Double AdjAmt) {
        this.AdjAmt = AdjAmt;
    }

    /**
     * @return the buyerSellerBillDt
     */
    public Date getBuyerSellerBillDt() {
        return buyerSellerBillDt;
    }

    /**
     * @param buyerSellerBillDt the buyerSellerBillDt to set
     */
    public void setBuyerSellerBillDt(Date buyerSellerBillDt) {
        this.buyerSellerBillDt = buyerSellerBillDt;
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
     * @return the buyerSellerName
     */
    public String getBuyerSellerName() {
        return buyerSellerName;
    }

    /**
     * @param buyerSellerName the buyerSellerName to set
     */
    public void setBuyerSellerName(String buyerSellerName) {
        this.buyerSellerName = buyerSellerName;
    }

    /**
     * @return the authRequired
     */
    public Integer getAuthRequired() {
        return authRequired;
    }

    /**
     * @param authRequired the authRequired to set
     */
    public void setAuthRequired(Integer authRequired) {
        this.authRequired = authRequired;
    }

    /**
     * @return the authStatus
     */
    public Integer getAuthStatus() {
        return authStatus;
    }

    /**
     * @param authStatus the authStatus to set
     */
    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    /**
     * @return the authDate
     */
    public Date getAuthDate() {
        return authDate;
    }

    /**
     * @param authDate the authDate to set
     */
    public void setAuthDate(Date authDate) {
        this.authDate = authDate;
    }

    /**
     * @return the authRemarks
     */
    public String getAuthRemarks() {
        return authRemarks;
    }

    /**
     * @param authRemarks the authRemarks to set
     */
    public void setAuthRemarks(String authRemarks) {
        this.authRemarks = authRemarks;
    }

    /**
     * @return the stockPosted
     */
    public Integer getStockPosted() {
        return stockPosted;
    }

    /**
     * @param stockPosted the stockPosted to set
     */
    public void setStockPosted(Integer stockPosted) {
        this.stockPosted = stockPosted;
    }

}
