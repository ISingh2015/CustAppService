/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cust.domain.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Inderjit
 */
@Entity
@Table(name = "Product")
public class ElegantProduct implements Serializable,Comparable<ElegantProduct> {

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
    @Column(name = "prodId")
    private long prodID;

    @Column(name = "prodName")
    private String prodName;

    @Column(name = "catNo")
    private String catNo;

    @Column(name = "subCatNo")
    private String subCatNo;

    @Column(name = "makeFlag")
    private Integer makeFlag = 0;

    @Column(name = "finishedGoodsFlag")
    private Integer finishedGoodsFlag = 0;

    @Column(name = "color")
    private String color;

    @Column(name = "opStock")
    private Double opStock = 0d;

    @Column(name = "minInStock")
    private Double minInStock = 0d;

    @Column(name = "reOrderPoint")
    private Double reOrderPoint = 0d;

    @Column(name = "standardCost")
    private Double standardCost = 0d;

    @Column(name = "listPrice")
    private Double listPrice = 0d;

    @Column(name = "size")
    private String size;

    @Column(name = "unitForSize")
    private String unitForSize;

    @Column(name = "weight")
    private Double weight = 0d;

    @Column(name = "unitForWeight")
    private String unitForWeight;

    @Column(name = "daysToManufacture")
    private Integer daysToManufacture = 0;

    @Column(name = "productLine")
    private Integer productLine = 0;

    @Column(name = "style")
    private Integer style = 0;

    @Column(name = "sellStartDate")
    private Date sellStartDate;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "active")
    private Integer active = 0;

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
     * @return the prodID
     */
    public long getProdID() {
        return prodID;
    }

    /**
     * @param prodID the prodID to set
     */
    public void setProdID(long prodID) {
        this.prodID = prodID;
    }

    /**
     * @return the prodName
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * @param prodName the prodName to set
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * @return the catNo
     */
    public String getCatNo() {
        return catNo;
    }

    /**
     * @param catNo the catNo to set
     */
    public void setCatNo(String catNo) {
        this.catNo = catNo;
    }

    /**
     * @return the subCatNo
     */
    public String getSubCatNo() {
        return subCatNo;
    }

    /**
     * @param subCatNo the subCatNo to set
     */
    public void setSubCatNo(String subCatNo) {
        this.subCatNo = subCatNo;
    }

    /**
     * @return the makeFlag
     */
    public Integer getMakeFlag() {
        return makeFlag;
    }

    /**
     * @param makeFlag the makeFlag to set
     */
    public void setMakeFlag(Integer makeFlag) {
        this.makeFlag = makeFlag;
    }

    /**
     * @return the finishedGoodsFlag
     */
    public Integer getFinishedGoodsFlag() {
        return finishedGoodsFlag;
    }

    /**
     * @param finishedGoodsFlag the finishedGoodsFlag to set
     */
    public void setFinishedGoodsFlag(Integer finishedGoodsFlag) {
        this.finishedGoodsFlag = finishedGoodsFlag;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the minInStock
     */
    public Double getMinInStock() {
        return minInStock;
    }

    /**
     * @param minInStock the minInStock to set
     */
    public void setMinInStock(Double minInStock) {
        this.minInStock = minInStock;
    }

    /**
     * @return the reOrderPoint
     */
    public Double getReOrderPoint() {
        return reOrderPoint;
    }

    /**
     * @param reOrderPoint the reOrderPoint to set
     */
    public void setReOrderPoint(Double reOrderPoint) {
        this.reOrderPoint = reOrderPoint;
    }

    /**
     * @return the standardCost
     */
    public Double getStandardCost() {
        return standardCost;
    }

    /**
     * @param standardCost the standardCost to set
     */
    public void setStandardCost(Double standardCost) {
        this.standardCost = standardCost;
    }

    /**
     * @return the listPrice
     */
    public Double getListPrice() {
        return listPrice;
    }

    /**
     * @param listPrice the listPrice to set
     */
    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the unitForSize
     */
    public String getUnitForSize() {
        return unitForSize;
    }

    /**
     * @param unitForSize the unitForSize to set
     */
    public void setUnitForSize(String unitForSize) {
        this.unitForSize = unitForSize;
    }

    /**
     * @return the weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * @return the unitForWeight
     */
    public String getUnitForWeight() {
        return unitForWeight;
    }

    /**
     * @param unitForWeight the unitForWeight to set
     */
    public void setUnitForWeight(String unitForWeight) {
        this.unitForWeight = unitForWeight;
    }

    /**
     * @return the daysToManufacture
     */
    public Integer getDaysToManufacture() {
        return daysToManufacture;
    }

    /**
     * @param daysToManufacture the daysToManufacture to set
     */
    public void setDaysToManufacture(Integer daysToManufacture) {
        this.daysToManufacture = daysToManufacture;
    }

    /**
     * @return the productLine
     */
    public Integer getProductLine() {
        return productLine;
    }

    /**
     * @param productLine the productLine to set
     */
    public void setProductLine(Integer productLine) {
        this.productLine = productLine;
    }

    /**
     * @return the style
     */
    public Integer getStyle() {
        return style;
    }

    /**
     * @param style the style to set
     */
    public void setStyle(Integer style) {
        this.style = style;
    }

    /**
     * @return the sellStartDate
     */
    public Date getSellStartDate() {
        return sellStartDate;
    }

    /**
     * @param sellStartDate the sellStartDate to set
     */
    public void setSellStartDate(Date sellStartDate) {
        this.sellStartDate = sellStartDate;
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
     * @return the active
     */
    public Integer getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public int compareTo(ElegantProduct o) {
        if (o == null) {
            return 0;
        }
        if (this.getProdID() < o.getProdID()) {
            return 1;
        } else if (this.getProdID() > o.getProdID()) {
            return -1;
        }
        return 0;
    }

    /**
     * @return the opStock
     */
    public Double getOpStock() {
        return opStock;
    }

    /**
     * @param opStock the opStock to set
     */
    public void setOpStock(Double opStock) {
        this.opStock = opStock;
    }

}
