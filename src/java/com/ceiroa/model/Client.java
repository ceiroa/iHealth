/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.model;

/**
 *
 * @author ceiroa
 */
public class Client {

    private long id;
    private String lastName;
    private String middleInitial;
    private String firstName;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String email;
    private String referrer;
    private String homePhone;
    private String cellPhone;
    private String workPhone;
    private String dob;
    private String ssn;
    private String driverLicense;
    private String employer;
    private String occupation;
    private String employerAddress;
    private String employerPhoneNum;
    private String contactName;
    private String contactRelation;
    private String contactPhone;
    private String insurance;
    private String insuranceAddress;
    private String policyHolderName;
    private String policyHolderAddress;
    private String policyHolderDob;
    private String policyHolderSsn;
    private String policyNumber;
    private String groupNumber;
    private String policyHolderRelation;
    private String insurance2;
    private String insuranceAddress2;
    private String policyHolderName2;
    private String policyHolderAddress2;
    private String policyHolderDob2;
    private String policyHolderSsn2;
    private String policyNumber2;
    private String groupNumber2;
    private String policyHolderRelation2;
    private String accidentInfo;
    private String compInfo;

    public Client() {}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAccidentInfo() {
        return accidentInfo;
    }

    public void setAccidentInfo(String accidentInfo) {
        this.accidentInfo = accidentInfo;
    }

    public String getCompInfo() {
        return compInfo;
    }

    public void setCompInfo(String compInfo) {
        this.compInfo = compInfo;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactRelation() {
        return contactRelation;
    }

    public void setContactRelation(String contactRelation) {
        this.contactRelation = contactRelation;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getEmployerPhoneNum() {
        return employerPhoneNum;
    }

    public void setEmployerPhoneNum(String employerPhoneNum) {
        this.employerPhoneNum = employerPhoneNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getGroupNumber2() {
        return groupNumber2;
    }

    public void setGroupNumber2(String groupNumber2) {
        this.groupNumber2 = groupNumber2;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getInsurance2() {
        return insurance2;
    }

    public void setInsurance2(String insurance2) {
        this.insurance2 = insurance2;
    }

    public String getInsuranceAddress() {
        return insuranceAddress;
    }

    public void setInsuranceAddress(String insuranceAddress) {
        this.insuranceAddress = insuranceAddress;
    }

    public String getInsuranceAddress2() {
        return insuranceAddress2;
    }

    public void setInsuranceAddress2(String insuranceAddress2) {
        this.insuranceAddress2 = insuranceAddress2;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPolicyHolderAddress() {
        return policyHolderAddress;
    }

    public void setPolicyHolderAddress(String policyHolderAddress) {
        this.policyHolderAddress = policyHolderAddress;
    }

    public String getPolicyHolderAddress2() {
        return policyHolderAddress2;
    }

    public void setPolicyHolderAddress2(String policyHolderAddress2) {
        this.policyHolderAddress2 = policyHolderAddress2;
    }

    public String getPolicyHolderDob() {
        return policyHolderDob;
    }

    public void setPolicyHolderDob(String policyHolderDob) {
        this.policyHolderDob = policyHolderDob;
    }

    public String getPolicyHolderDob2() {
        return policyHolderDob2;
    }

    public void setPolicyHolderDob2(String policyHolderDob2) {
        this.policyHolderDob2 = policyHolderDob2;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public String getPolicyHolderName2() {
        return policyHolderName2;
    }

    public void setPolicyHolderName2(String policyHolderName2) {
        this.policyHolderName2 = policyHolderName2;
    }

    public String getPolicyHolderRelation() {
        return policyHolderRelation;
    }

    public void setPolicyHolderRelation(String policyHolderRelation) {
        this.policyHolderRelation = policyHolderRelation;
    }

    public String getPolicyHolderRelation2() {
        return policyHolderRelation2;
    }

    public void setPolicyHolderRelation2(String policyHolderRelation2) {
        this.policyHolderRelation2 = policyHolderRelation2;
    }

    public String getPolicyHolderSsn() {
        return policyHolderSsn;
    }

    public void setPolicyHolderSsn(String policyHolderSsn) {
        this.policyHolderSsn = policyHolderSsn;
    }

    public String getPolicyHolderSsn2() {
        return policyHolderSsn2;
    }

    public void setPolicyHolderSsn2(String policyHolderSsn2) {
        this.policyHolderSsn2 = policyHolderSsn2;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyNumber2() {
        return policyNumber2;
    }

    public void setPolicyNumber2(String policyNumber2) {
        this.policyNumber2 = policyNumber2;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }


}
