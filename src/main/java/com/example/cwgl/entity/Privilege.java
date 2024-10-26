package com.example.cwgl.entity;

public class Privilege {
    private Integer ID;
    private String privilegeNumber;
    private String privilegeName;
    private String privilegeTipflag;
    private String privilegeTypeflag;
    private String privilegeUrl;
    private String icon;

    public Privilege() {
    }

    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer iD) {
        this.ID = iD;
    }

    public String getPrivilegeNumber() {
        return this.privilegeNumber;
    }

    public void setPrivilegeNumber(String privilegeNumber) {
        this.privilegeNumber = privilegeNumber;
    }

    public String getPrivilegeName() {
        return this.privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeTipflag() {
        return this.privilegeTipflag;
    }

    public void setPrivilegeTipflag(String privilegeTipflag) {
        this.privilegeTipflag = privilegeTipflag;
    }

    public String getPrivilegeTypeflag() {
        return this.privilegeTypeflag;
    }

    public void setPrivilegeTypeflag(String privilegeTypeflag) {
        this.privilegeTypeflag = privilegeTypeflag;
    }

    public String getPrivilegeUrl() {
        return this.privilegeUrl;
    }

    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

