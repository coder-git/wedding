package com.demo.model;

public class SysFormInfo {
    private Integer id;

    private Integer customerid;

    private Integer categoryid;

    private String formname;

    private String formdescription;

    private String qrcode;

    private Long createtime;

    public SysFormInfo(Integer id, Integer customerid, Integer categoryid, String formname, String formdescription, String qrcode, Long createtime) {
        this.id = id;
        this.customerid = customerid;
        this.categoryid = categoryid;
        this.formname = formname;
        this.formdescription = formdescription;
        this.qrcode = qrcode;
        this.createtime = createtime;
    }

    public SysFormInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname == null ? null : formname.trim();
    }

    public String getFormdescription() {
        return formdescription;
    }

    public void setFormdescription(String formdescription) {
        this.formdescription = formdescription == null ? null : formdescription.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
}