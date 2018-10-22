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
 * @author Zed
 */
@Entity
@Table(name = "MarketEmails")

public class ElegantMarketMail implements Serializable{
    
    private static long serialVersionUID = 4173435938575881525L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @Column(name = "srl")
    private long srlId;
    

    @Column(name = "emailToAddress")
    private String emailToAddress;

    @Column(name = "emailccAddress")
    private String emailCcAddress;

    @Column(name = "emailbccAddress")
    private String emailBccAddress;

    @Column(name = "emailSubject")
    private String emailSubject;

    @Column(name = "message")
    private String emailMessage;

    @Column(name = "createDate")
    private Date createDate;

    /**
     * @return the srlId
     */
    public long getSrlId() {
        return srlId;
    }

    /**
     * @param srlId the srlId to set
     */
    public void setSrlId(long srlId) {
        this.srlId = srlId;
    }


    /**
     * @return the emailMessage
     */
    public String getEmailMessage() {
        return emailMessage;
    }

    /**
     * @param emailMessage the emailMessage to set
     */
    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
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
     * @return the emailSubject
     */
    public String getEmailSubject() {
        return emailSubject;
    }

    /**
     * @param emailSubject the emailSubject to set
     */
    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    /**
     * @return the emailToAddress
     */
    public String getEmailToAddress() {
        return emailToAddress;
    }

    /**
     * @param emailToAddress the emailToAddress to set
     */
    public void setEmailToAddress(String emailToAddress) {
        this.emailToAddress = emailToAddress;
    }

    /**
     * @return the emailCcAddress
     */
    public String getEmailCcAddress() {
        return emailCcAddress;
    }

    /**
     * @param emailCcAddress the emailCcAddress to set
     */
    public void setEmailCcAddress(String emailCcAddress) {
        this.emailCcAddress = emailCcAddress;
    }

    /**
     * @return the emailBccAddress
     */
    public String getEmailBccAddress() {
        return emailBccAddress;
    }

    /**
     * @param emailBccAddress the emailBccAddress to set
     */
    public void setEmailBccAddress(String emailBccAddress) {
        this.emailBccAddress = emailBccAddress;
    }

}
