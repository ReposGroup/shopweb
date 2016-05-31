package com.luis.system.model;

import java.sql.Timestamp;

public class SystemLog  implements java.io.Serializable {
	 private static final long serialVersionUID = 6579011042931972487L;
	//属性
     private Integer id;
     private String title;
     private String content;
     private Integer type;
     private String account;
     private String loginIp;
     private Timestamp logintime;
     private String loginArea;
     private String diffAreaLogin;
     private Timestamp createtime;
     private Timestamp updatetime;
     private String createBy;
     private String updateBy;
     private String definitionOne;
     private String definitionTwo;
   //构造方法
    public SystemLog() {
    }

    public SystemLog(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public SystemLog(String title, String content, Integer type, String account, String loginIp, Timestamp logintime, String loginArea, String diffAreaLogin, Timestamp createtime, Timestamp updatetime, String createBy, String updateBy, String definitionOne, String definitionTwo) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.account = account;
        this.loginIp = loginIp;
        this.logintime = logintime;
        this.loginArea = loginArea;
        this.diffAreaLogin = diffAreaLogin;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.definitionOne = definitionOne;
        this.definitionTwo = definitionTwo;
    }

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccount() {
        return this.account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }

    public String getLoginIp() {
        return this.loginIp;
    }
    
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Timestamp getLogintime() {
        return this.logintime;
    }
    
    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    public String getLoginArea() {
        return this.loginArea;
    }
    
    public void setLoginArea(String loginArea) {
        this.loginArea = loginArea;
    }

    public String getDiffAreaLogin() {
        return this.diffAreaLogin;
    }
    
    public void setDiffAreaLogin(String diffAreaLogin) {
        this.diffAreaLogin = diffAreaLogin;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateBy() {
        return this.createBy;
    }
    
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getDefinitionOne() {
        return this.definitionOne;
    }
    
    public void setDefinitionOne(String definitionOne) {
        this.definitionOne = definitionOne;
    }

    public String getDefinitionTwo() {
        return this.definitionTwo;
    }
    
    public void setDefinitionTwo(String definitionTwo) {
        this.definitionTwo = definitionTwo;
    }
   








}