package com.cust.domain.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
//import orgs.hibernate.envers.Audited;

@Entity
@Table(name = "Country")
@Audited
public class ElegantCountry implements Serializable, Comparable<ElegantCountry> {

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
    @Column(name = "countryId")
    private long countryID;

    @Column(name = "countryCd")
    private String countryCd;

    @Column(name = "countryName")
    private String countryName = "";

    @Column(name = "currency")
    private String currency = "";

    @Column(name = "exchangeRate")
    private Double exchangeRate = 0d;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "frozen")
    private Integer disabled = 0;

    public long getCountryID() {
        return countryID;
    }

    public void setCountryID(long countryID) {
        this.countryID = countryID;
    }

    public String getCountryCd() {
        return countryCd;
    }

    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public static long getSerialversionuid() {
        return getSerialVersionUID();
    }

    @Override
    public int compareTo(ElegantCountry o) {
        if (o == null) {
            return 0;
        }
        if (this.getCountryID() < o.getCountryID()) {
            return 1;
        } else if (this.getCountryID() > o.getCountryID()) {
            return -1;
        }
        return 0;

    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the exchangeRate
     */
    public Double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * @param exchangeRate the exchangeRate to set
     */
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
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
     * @return the disabled
     */
    public Integer getDisabled() {
        return disabled;
    }

    /**
     * @param disabled the disabled to set
     */
    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }
    public String toString () {
        return this.countryName;
    }
}
