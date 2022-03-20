package com.demo.model;

public class User {
    private Integer userid;

    private String username;

    private String useraccount;

    private String userpassword;

    private String usertelephonenumber;

    private Long createtime;

    private String usersalt;

    public User(Integer userid, String username, String useraccount, String userpassword, String usertelephonenumber, Long createtime, String usersalt) {
        this.userid = userid;
        this.username = username;
        this.useraccount = useraccount;
        this.userpassword = userpassword;
        this.usertelephonenumber = usertelephonenumber;
        this.createtime = createtime;
        this.usersalt = usersalt;
    }

    public User() {
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

    public String getUsertelephonenumber() {
        return usertelephonenumber;
    }

    public void setUsertelephonenumber(String usertelephonenumber) {
        this.usertelephonenumber = usertelephonenumber == null ? null : usertelephonenumber.trim();
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