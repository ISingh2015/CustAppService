package com.cust.domain.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Users")
//@Audited
public class ElegantUser implements Serializable, Comparable<ElegantUser> {

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
    @Column(name = "userId")
    private long userID;

    @Column(name = "userLoginName")
    private String userLoginName;

    @Column(name = "userLoginPwd")
    private String userLoginPwd;

    @Column(name = "name")
    private String userName;

    @Column(name = "address")
    private String userAddress;

    @Column(name = "country")
    private String country="";

    @Column(name = "city")
    private String city="";

    @Column(name = "state")
    private String state="";

    @Column(name = "pincode")
    private Integer pinCode;

    @Column(name = "telno")
    private String telephoneNo="";

    @Column(name = "mobileno")
    private String mobileNo="";

    @Column(name = "email")
    private String emailId;

    @Column(name = "website")
    private String webSite;

    @Column(name = "accountType")
    private Integer accountType = 0;

    @Column(name = "memberSince")
    private Date membershipDate;

    @Column(name = "accountStatus")
    private Integer accountStatus = 0;

    @Column(name = "activationDate")
    private Date activationDate;

    @Column(name = "accountlocked")
    private Integer accountLocked = 0;

    @Column(name = "accountlockedTime")
    private Date accountLockedTime;

    @Column(name = "gracePeriod")
    private Integer gracePeriod = 0;

    @Column(name = "loggedIn")
    private Integer loggedIn = 0;

    @Column(name = "loggedInIp")
    private String loggedInIp = "";

    @Column(name = "loggedInDate")
    private Date loggedInDate;

    @Column(name = "inventory")
    private Integer accessInventory = 0;

    @Column(name = "accounting")
    private Integer accessAccounting = 0;

    @Column(name = "payroll")
    private Integer accessPayroll = 0;

    @Column(name = "auditing")
    private Integer auditing = 0;

    @Column(name = "division")
    private Integer division = 0;

    @Column(name = "role")
    private Integer role = 0;
    
    @Transient
    private ArrayList<ElegantUserAccess> elegantUserAccessList;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserLoginPwd() {
        return userLoginPwd;
    }

    public void setUserLoginPwd(String userLoginPwd) {
        this.userLoginPwd = userLoginPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public int compareTo(ElegantUser o) {
        if (o == null) {
            return 0;
        }
        if (this.getUserID() < o.getUserID()) {
            return 1;
        } else if (this.getUserID() > o.getUserID()) {
            return -1;
        }
        return 0;
    }

//    public int compare(ElegantUser o1, ElegantUser o2) {
//        return new Long(o1.getUserID() - o2.getUserID()).intValue();
//    }
//
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
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the webSite
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * @param webSite the webSite to set
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    /**
     * @return the elegantUserAccessList
     */
    public ArrayList<ElegantUserAccess> getElegantUserAccessList() {
        return elegantUserAccessList;
    }

    /**
     * @param elegantUserAccessList the elegantUserAccessList to set
     */
    public void setElegantUserAccessList(ArrayList<ElegantUserAccess> elegantUserAccessList) {
        this.elegantUserAccessList = elegantUserAccessList;
    }

    /**
     * @return the accountLocked
     */
    public Integer getAccountLocked() {
        return accountLocked;
    }

    /**
     * @param accountLocked the accountLocked to set
     */
    public void setAccountLocked(Integer accountLocked) {
        this.accountLocked = accountLocked;
    }

    /**
     * @return the accountLockedTime
     */
    public Date getAccountLockedTime() {
        return accountLockedTime;
    }

    /**
     * @param accountLockedTime the accountLockedTime to set
     */
    public void setAccountLockedTime(Date accountLockedTime) {
        this.accountLockedTime = accountLockedTime;
    }

    /**
     * @return the gracePeriod
     */
    public Integer getGracePeriod() {
        return gracePeriod;
    }

    /**
     * @param gracePeriod the gracePeriod to set
     */
    public void setGracePeriod(Integer gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    /**
     * @return the loggedIn
     */
    public Integer getLoggedIn() {
        return loggedIn;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(Integer loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * @return the loggedInIp
     */
    public String getLoggedInIp() {
        return loggedInIp;
    }

    /**
     * @param loggedInIp the loggedInIp to set
     */
    public void setLoggedInIp(String loggedInIp) {
        this.loggedInIp = loggedInIp;
    }

    /**
     * @return the loggedInDate
     */
    public Date getLoggedInDate() {
        return loggedInDate;
    }

    /**
     * @param loggedInDate the loggedInDate to set
     */
    public void setLoggedInDate(Date loggedInDate) {
        this.loggedInDate = loggedInDate;
    }

    /**
     * @return the auditing
     */
    public Integer getAuditing() {
        return auditing;
    }

    /**
     * @param auditing the auditing to set
     */
    public void setAuditing(Integer auditing) {
        this.auditing = auditing;
    }

    /**
     * @return the accessInventory
     */
    public Integer getAccessInventory() {
        return accessInventory;
    }

    /**
     * @param accessInventory the accessInventory to set
     */
    public void setAccessInventory(Integer accessInventory) {
        this.accessInventory = accessInventory;
    }

    /**
     * @return the accessAccounting
     */
    public Integer getAccessAccounting() {
        return accessAccounting;
    }

    /**
     * @param accessAccounting the accessAccounting to set
     */
    public void setAccessAccounting(Integer accessAccounting) {
        this.accessAccounting = accessAccounting;
    }

    /**
     * @return the accessPayroll
     */
    public Integer getAccessPayroll() {
        return accessPayroll;
    }

    /**
     * @param accessPayroll the accessPayroll to set
     */
    public void setAccessPayroll(Integer accessPayroll) {
        this.accessPayroll = accessPayroll;
    }

    /**
     * @return the division
     */
    public Integer getDivision() {
        return division;
    }

    /**
     * @param division the division to set
     */
    public void setDivision(Integer division) {
        this.division = division;
    }

    /**
     * @return the role
     */
    public Integer getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * @return the accountStatus
     */
    public Integer getAccountStatus() {
        return accountStatus;
    }

    /**
     * @param accountStatus the accountStatus to set
     */
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * @return the activationDate
     */
    public Date getActivationDate() {
        return activationDate;
    }

    /**
     * @param activationDate the activationDate to set
     */
    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

}
