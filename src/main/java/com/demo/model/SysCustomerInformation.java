package com.demo.model;

public class SysCustomerInformation {
    private Integer customerid;

    private Integer formid;

    private String fullname;

    private String gender;

    private String nationality;

    private Byte height;

    private String birthday;

    private String education;

    private String companyandoccupation;

    private String maritalstatus;

    private String workingaddress;

    private String phonenumber;

    private Integer weight;

    private String income;

    private String introduceyourself;

    private String spouserequirements;

    private String halfLengthphoto;

    private String fullbodyphoto;

    private Long createtime;

    public SysCustomerInformation(Integer customerid, Integer formid, String fullname, String gender, String nationality, Byte height, String birthday, String education, String companyandoccupation, String maritalstatus, String workingaddress, String phonenumber, Integer weight, String income, String introduceyourself, String spouserequirements, String halfLengthphoto, String fullbodyphoto, Long createtime) {
        this.customerid = customerid;
        this.formid = formid;
        this.fullname = fullname;
        this.gender = gender;
        this.nationality = nationality;
        this.height = height;
        this.birthday = birthday;
        this.education = education;
        this.companyandoccupation = companyandoccupation;
        this.maritalstatus = maritalstatus;
        this.workingaddress = workingaddress;
        this.phonenumber = phonenumber;
        this.weight = weight;
        this.income = income;
        this.introduceyourself = introduceyourself;
        this.spouserequirements = spouserequirements;
        this.halfLengthphoto = halfLengthphoto;
        this.fullbodyphoto = fullbodyphoto;
        this.createtime = createtime;
    }

    public SysCustomerInformation() {
        super();
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getFormid() {
        return formid;
    }

    public void setFormid(Integer formid) {
        this.formid = formid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public Byte getHeight() {
        return height;
    }

    public void setHeight(Byte height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getCompanyandoccupation() {
        return companyandoccupation;
    }

    public void setCompanyandoccupation(String companyandoccupation) {
        this.companyandoccupation = companyandoccupation == null ? null : companyandoccupation.trim();
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus == null ? null : maritalstatus.trim();
    }

    public String getWorkingaddress() {
        return workingaddress;
    }

    public void setWorkingaddress(String workingaddress) {
        this.workingaddress = workingaddress == null ? null : workingaddress.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public String getIntroduceyourself() {
        return introduceyourself;
    }

    public void setIntroduceyourself(String introduceyourself) {
        this.introduceyourself = introduceyourself == null ? null : introduceyourself.trim();
    }

    public String getSpouserequirements() {
        return spouserequirements;
    }

    public void setSpouserequirements(String spouserequirements) {
        this.spouserequirements = spouserequirements == null ? null : spouserequirements.trim();
    }

    public String getHalfLengthphoto() {
        return halfLengthphoto;
    }

    public void setHalfLengthphoto(String halfLengthphoto) {
        this.halfLengthphoto = halfLengthphoto == null ? null : halfLengthphoto.trim();
    }

    public String getFullbodyphoto() {
        return fullbodyphoto;
    }

    public void setFullbodyphoto(String fullbodyphoto) {
        this.fullbodyphoto = fullbodyphoto == null ? null : fullbodyphoto.trim();
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
}