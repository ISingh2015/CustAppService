package com.cust.domain.vo;

import java.io.Serializable;

public class AddressXML implements Serializable {

    private static final long serialVersionUID = 4173435938575881525L;
    private String address, city, state, emailId, webSite;
    private Long pin, telephone, mobile, faxNo,country;

    public AddressXML(String address, String city, String state, Long pin, Long country, String emailId, String webSite, Long telephone, Long mobile, Long faxNo) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.country = country;
        this.emailId = emailId;
        this.webSite = webSite;
        this.telephone = telephone;
        this.mobile = mobile;
        this.faxNo = faxNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobil) {
        this.mobile = mobil;
    }

    public Long getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(Long faxNo) {
        this.faxNo = faxNo;
    }

}
