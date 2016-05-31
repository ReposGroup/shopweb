package com.luis.system.model;

import java.sql.Timestamp;

public class Rights  implements java.io.Serializable {
	 private static final long serialVersionUID = 6704249530423366155L;
	//属性
	 private Integer id;
     private Integer roleId;
     private Integer moduleId;
     private Timestamp createtime;
     private Timestamp updatetime;
     private String createBy;
     private String updateBy;
     private String definitionOne;
     private String definitionTwo;
   //构造方法
    public Rights() {
    }

    public Rights(Integer roleId, Integer moduleId) {
        this.roleId = roleId;
        this.moduleId = moduleId;
    }
    
    public Rights(Integer roleId, Integer moduleId, Timestamp createtime, Timestamp updatetime, String createBy, String updateBy, String definitionOne, String definitionTwo) {
        this.roleId = roleId;
        this.moduleId = moduleId;
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

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return this.moduleId;
    }
    
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
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