package com.demo.model;

public class SysAdmin {
    private Integer id;

    private String systemaccount;

    private String systempassword;

    private String systemsaltkey;


    /**
     *
     * @param id
     * @param systemaccount
     * @param systempassword
     * @param systemsaltkey
     */
    public SysAdmin(Integer id, String systemaccount, String systempassword, String systemsaltkey) {
        this.id = id;
        this.systemaccount = systemaccount;
        this.systempassword = systempassword;
        this.systemsaltkey = systemsaltkey;
    }

    public SysAdmin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystemaccount() {
        return systemaccount;
    }

    public void setSystemaccount(String systemaccount) {
        this.systemaccount = systemaccount == null ? null : systemaccount.trim();
    }

    public String getSystempassword() {
        return systempassword;
    }

    public void setSystempassword(String systempassword) {
        this.systempassword = systempassword == null ? null : systempassword.trim();
    }

    public String getSystemsaltkey() {
        return systemsaltkey;
    }

    public void setSystemsaltkey(String systemsaltkey) {
        this.systemsaltkey = systemsaltkey == null ? null : systemsaltkey.trim();
    }
}