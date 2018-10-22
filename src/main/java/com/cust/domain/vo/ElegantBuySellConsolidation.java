/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ISanhot
 */
public class ElegantBuySellConsolidation implements Serializable{
    private int compId,userId,billId,srl,productId,billType;
    private String buyersellerCode,buyersellerName,buyersellerBillno,billno,salesmanCode,unitPackaging;
    private Date buyersellerBilldt, billDate;
    private double finalBillamt,purchQty,purchRtnqty,billedQty,billedRtnqty,billedRate,unitDiscount,unitAmt,purchRate;
    private double pendingPurQty,pendingInvQty;
    /**
     * @return the compId
     */
    public int getCompId() {
        return compId;
    }

    /**
     * @param compId the compId to set
     */
    public void setCompId(int compId) {
        this.compId = compId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the billId
     */
    public int getBillId() {
        return billId;
    }

    /**
     * @param billId the billId to set
     */
    public void setBillId(int billId) {
        this.billId = billId;
    }

    /**
     * @return the srl
     */
    public int getSrl() {
        return srl;
    }

    /**
     * @param srl the srl to set
     */
    public void setSrl(int srl) {
        this.srl = srl;
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }


    /**
     * @return the buyersellerName
     */
    public String getBuyersellerName() {
        return buyersellerName;
    }

    /**
     * @param buyersellerName the buyersellerName to set
     */
    public void setBuyersellerName(String buyersellerName) {
        this.buyersellerName = buyersellerName;
    }


    /**
     * @return the billno
     */
    public String getBillno() {
        return billno;
    }

    /**
     * @param billno the billno to set
     */
    public void setBillno(String billno) {
        this.billno = billno;
    }

    /**
     * @return the salesmanCode
     */
    public String getSalesmanCode() {
        return salesmanCode;
    }

    /**
     * @param salesmanCode the salesmanCode to set
     */
    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode;
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
     * @return the finalBillamt
     */
    public double getFinalBillamt() {
        return finalBillamt;
    }

    /**
     * @param finalBillamt the finalBillamt to set
     */
    public void setFinalBillamt(double finalBillamt) {
        this.finalBillamt = finalBillamt;
    }

    /**
     * @return the purchQty
     */
    public double getPurchQty() {
        return purchQty;
    }

    /**
     * @param purchQty the purchQty to set
     */
    public void setPurchQty(double purchQty) {
        this.purchQty = purchQty;
    }

    /**
     * @return the purchRtnqty
     */
    public double getPurchRtnqty() {
        return purchRtnqty;
    }

    /**
     * @param purchRtnqty the purchRtnqty to set
     */
    public void setPurchRtnqty(double purchRtnqty) {
        this.purchRtnqty = purchRtnqty;
    }

    /**
     * @return the billedQty
     */
    public double getBilledQty() {
        return billedQty;
    }

    /**
     * @param billedQty the billedQty to set
     */
    public void setBilledQty(double billedQty) {
        this.billedQty = billedQty;
    }

    /**
     * @return the billedRtnqty
     */
    public double getBilledRtnqty() {
        return billedRtnqty;
    }

    /**
     * @param billedRtnqty the billedRtnqty to set
     */
    public void setBilledRtnqty(double billedRtnqty) {
        this.billedRtnqty = billedRtnqty;
    }

    /**
     * @return the purchRate
     */
    public double getPurchRate() {
        return purchRate;
    }

    /**
     * @param purchRate the purchRate to set
     */
    public void setPurchRate(double purchRate) {
        this.purchRate = purchRate;
    }

    /**
     * @return the billedRate
     */
    public double getBilledRate() {
        return billedRate;
    }

    /**
     * @param billedRate the billedRate to set
     */
    public void setBilledRate(double billedRate) {
        this.billedRate = billedRate;
    }

    /**
     * @return the unitDiscount
     */
    public double getUnitDiscount() {
        return unitDiscount;
    }

    /**
     * @param unitDiscount the unitDiscount to set
     */
    public void setUnitDiscount(double unitDiscount) {
        this.unitDiscount = unitDiscount;
    }

    /**
     * @return the unitAmt
     */
    public double getUnitAmt() {
        return unitAmt;
    }

    /**
     * @param unitAmt the unitAmt to set
     */
    public void setUnitAmt(double unitAmt) {
        this.unitAmt = unitAmt;
    }

    /**
     * @return the buyersellerBilldt
     */
    public Date getBuyersellerBilldt() {
        return buyersellerBilldt;
    }

    /**
     * @param buyersellerBilldt the buyersellerBilldt to set
     */
    public void setBuyersellerBilldt(Date buyersellerBilldt) {
        this.buyersellerBilldt = buyersellerBilldt;
    }

    /**
     * @return the billDate
     */
    public Date getBillDate() {
        return billDate;
    }

    /**
     * @param billDate the billDate to set
     */
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    /**
     * @return the billType
     */
    public int getBillType() {
        return billType;
    }

    /**
     * @param billType the billType to set
     */
    public void setBillType(int billType) {
        this.billType = billType;
    }

    /**
     * @return the buyersellerCode
     */
    public String getBuyersellerCode() {
        return buyersellerCode;
    }

    /**
     * @param buyersellerCode the buyersellerCode to set
     */
    public void setBuyersellerCode(String buyersellerCode) {
        this.buyersellerCode = buyersellerCode;
    }

    /**
     * @return the buyersellerBillno
     */
    public String getBuyersellerBillno() {
        return buyersellerBillno;
    }

    /**
     * @param buyersellerBillno the buyersellerBillno to set
     */
    public void setBuyersellerBillno(String buyersellerBillno) {
        this.buyersellerBillno = buyersellerBillno;
    }

    /**
     * @return the pendingPurQty
     */
    public double getPendingPurQty() {
        pendingPurQty=getPurchQty()-getPurchRtnqty();
        return pendingPurQty;
    }

    /**
     * @param pendingPurQty the pendingPurQty to set
     */
    public void setPendingPurQty(double pendingPurQty) {
        this.pendingPurQty = pendingPurQty;
    }

    /**
     * @return the pendingInvQty
     */
    public double getPendingInvQty() {
        pendingInvQty = getBilledQty()-getBilledRtnqty();
        return pendingInvQty;
    }

    /**
     * @param pendingInvQty the pendingInvQty to set
     */
    public void setPendingInvQty(double pendingInvQty) {
        this.pendingInvQty = pendingInvQty;
    }


}
