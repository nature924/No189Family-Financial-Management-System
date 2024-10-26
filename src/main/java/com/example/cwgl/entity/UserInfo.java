package com.example.cwgl.entity;

import java.util.List;

public class UserInfo {
    private Integer id;
    private String username;    //用户名
    private String password;    //密码
    private String realname;    //真实姓名
    private Integer roleid;     //所属角色id 1:系统管理员 2:家主 3:普通家庭成员
    private String rolename;
    private String houseid;    //所属家庭编号    系统管理员为null
    private String iconUrl;     //图像路径
    private String signature;   //个性签名
    private List<Privilege> privileges;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if ("".equals(username.trim())) return;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        if ("".equals(realname.trim())) return;
        this.realname = realname;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        if (houseid==null || houseid.length()==0){
            this.houseid = null;
        }else {
            this.houseid = houseid;
        }
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", houseid='" + houseid + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", signature='" + signature + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
