package com.demo.model;

public class SysUser {
    private Integer userid;

    private String username;

    private String useraccount;

    private String userpassword;

    private Integer usertelephonenumber;

    private Long createtime;

    private String usersalt;


    /**
     *
     * @param userid
     * @param username
     * @param useraccount
     * @param userpassword
     * @param usertelephonenumber
     * @param createtime
     * @param usersalt
     */
    public SysUser(Integer userid, String username, String useraccount, String userpassword, Integer usertelephonenumber, Long createtime, String usersalt) {
        this.userid = userid;
        this.username = username;
        this.useraccount = useraccount;
        this.userpassword = userpassword;
        this.usertelephonenumber = usertelephonenumber;
        this.createtime = createtime;
        this.usersalt = usersalt;
    }

    public SysUser() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount == null ? null : useraccount.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public Integer getUsertelephonenumber() {
        return usertelephonenumber;
    }

    public void setUsertelephonenumber(Integer usertelephonenumber) {
        this.usertelephonenumber = usertelephonenumber;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public String getUsersalt() {
        return usersalt;
    }

    public void setUsersalt(String usersalt) {
        this.usersalt = usersalt == null ? null : usersalt.trim();
    }
}