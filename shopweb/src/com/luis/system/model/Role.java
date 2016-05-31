package com.luis.system.model;

import java.sql.Timestamp;

public class Role  implements java.io.Serializable {

	 private static final long serialVersionUID = -2013875420506912857L;
	//属性
     private Integer id;
     private String roleName;
     private String roleDesc;
     private String dbRights;
     private String status;
     private Timestamp createtime;
     private Timestamp updatetime;
     private String createBy;
     private String updateBy;
     private String definitionOne;
     private String definitionTwo;
   //构造方法
    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
    
    public Role(String roleName, String roleDesc, String dbRights, String status, Timestamp createtime, Timestamp updatetime, String createBy, String updateBy, String definitionOne, String definitionTwo) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.dbRights = dbRights;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.definitionOne = definitionOne;
        this.definitionTwo = definitionTwo;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return this.roleDesc;
    }
    
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getDbRights() {
        return this.dbRights;
    }
    
    public void setDbRights(String dbRights) {
        this.dbRights = dbRights;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
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