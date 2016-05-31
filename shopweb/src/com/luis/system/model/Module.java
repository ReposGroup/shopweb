package com.luis.system.model;

import java.sql.Timestamp;

public class Module  implements java.io.Serializable {
	
	 private static final long serialVersionUID = 8809148354036340865L;
	//属性
	 private Integer id;
     private Integer parentId;
     private String moduleUrl;
     private String moduleName;
     private Integer orderNum;
     private String type;
     private Timestamp createtime;
     private Timestamp updatetime;
     private String createBy;
     private String updateBy;
     private String definitionOne;
     private String definitionTwo;

   //构造方法
    public Module() {
    }

    public Module(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public Module(Integer parentId, String moduleUrl, String moduleName, Integer orderNum, String type, Timestamp createtime, Timestamp updatetime, String createBy, String updateBy, String definitionOne, String definitionTwo) {
        this.parentId = parentId;
        this.moduleUrl = moduleUrl;
        this.moduleName = moduleName;
        this.orderNum = orderNum;
        this.type = type;
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

    public Integer getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getModuleUrl() {
        return this.moduleUrl;
    }
    
    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getModuleName() {
        return this.moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getOrderNum() {
        return this.orderNum;
    }
    
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
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