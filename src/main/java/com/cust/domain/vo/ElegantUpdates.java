package com.cust.domain.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UpdatesOnTable")
public class ElegantUpdates implements Serializable {

    private static final long serialVersionUID = 4173435938575881525L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @Column(name = "Id")
    private long ID;

    @Column(name = "country")
    private Integer countryUpdated;

    @Column(name = "salesMan")
    private Integer salesManUpdated;

    @Column(name = "product")
    private Integer productUpdated;

    @Column(name = "supplier")
    private Integer supplierUpdated;

    @Column(name = "customer")
    private Integer customerUpdated;

    @Column(name = "purbills")
    private Integer purchaseUpdated;

    @Column(name = "salebills")
    private Integer salesUpdated;

    /**
     * @return the ID
     */
    public long getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(long ID) {
        this.ID = ID;
    }

    /**
     * @return the countryUpdated
     */
    public Integer getCountryUpdated() {
        return countryUpdated;
    }

    /**
     * @param countryUpdated the countryUpdated to set
     */
    public void setCountryUpdated(Integer countryUpdated) {
        this.countryUpdated = countryUpdated;
    }

    /**
     * @return the salesManUpdated
     */
    public Integer getSalesManUpdated() {
        return salesManUpdated;
    }

    /**
     * @param salesManUpdated the salesManUpdated to set
     */
    public void setSalesManUpdated(Integer salesManUpdated) {
        this.salesManUpdated = salesManUpdated;
    }

    /**
     * @return the productUpdated
     */
    public Integer getProductUpdated() {
        return productUpdated;
    }

    /**
     * @param productUpdated the productUpdated to set
     */
    public void setProductUpdated(Integer productUpdated) {
        this.productUpdated = productUpdated;
    }

    /**
     * @return the supplierUpdated
     */
    public Integer getSupplierUpdated() {
        return supplierUpdated;
    }

    /**
     * @param supplierUpdated the supplierUpdated to set
     */
    public void setSupplierUpdated(Integer supplierUpdated) {
        this.supplierUpdated = supplierUpdated;
    }

    /**
     * @return the customerUpdated
     */
    public Integer getCustomerUpdated() {
        return customerUpdated;
    }

    /**
     * @param customerUpdated the customerUpdated to set
     */
    public void setCustomerUpdated(Integer customerUpdated) {
        this.customerUpdated = customerUpdated;
    }

    /**
     * @return the purchaseUpdated
     */
    public Integer getPurchaseUpdated() {
        return purchaseUpdated;
    }

    /**
     * @param purchaseUpdated the purchaseUpdated to set
     */
    public void setPurchaseUpdated(Integer purchaseUpdated) {
        this.purchaseUpdated = purchaseUpdated;
    }

    /**
     * @return the salesUpdated
     */
    public Integer getSalesUpdated() {
        return salesUpdated;
    }

    /**
     * @param salesUpdated the salesUpdated to set
     */
    public void setSalesUpdated(Integer salesUpdated) {
        this.salesUpdated = salesUpdated;
    }

}
