package com.luis.system.model;

import java.sql.Timestamp;

public class SystemSetting  implements java.io.Serializable {
	 private static final long serialVersionUID = -6276916254950229139L;
	//属性
     private Integer id;
     private String systemCode;
     private String name;
     private String www;
     private String log;
     private String title;
     private String description;
     private String keywords;
     private String shortcuticon;
     private String address;
     private String tel;
     private String email;
     private String icp;
     private String isopen;
     private String closeMsg;
     private String qq;
     private String imageRootPath;
     private String manageHttp;
     private String defaultProductImg;
     private String style;
     private String version;
     private String qqHelpHtml;
     private String images;
     private String manageLeftTreeLeafIcon;
     private String statisticsCode;
     private String openResponsive;
     private Timestamp createtime;
     private Timestamp updatetime;
     private String createBy;
     private String updateBy;
     private String definitionOne;
     private String definitionTwo;
     
   //构造方法
    public SystemSetting() {
    }

    public SystemSetting(String name, String www, String title, String description, String keywords, String shortcuticon, String icp, String isopen) {
        this.name = name;
        this.www = www;
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.shortcuticon = shortcuticon;
        this.icp = icp;
        this.isopen = isopen;
    }
    
    public SystemSetting(String systemCode, String name, String www, String log, String title, String description, String keywords, String shortcuticon, String address, String tel, String email, String icp, String isopen, String closeMsg, String qq, String imageRootPath, String manageHttp, String defaultProductImg, String style, String version, String qqHelpHtml, String images, String manageLeftTreeLeafIcon, String statisticsCode, String openResponsive, Timestamp createtime, Timestamp updatetime, String createBy, String updateBy, String definitionOne, String definitionTwo) {
        this.systemCode = systemCode;
        this.name = name;
        this.www = www;
        this.log = log;
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.shortcuticon = shortcuticon;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.icp = icp;
        this.isopen = isopen;
        this.closeMsg = closeMsg;
        this.qq = qq;
        this.imageRootPath = imageRootPath;
        this.manageHttp = manageHttp;
        this.defaultProductImg = defaultProductImg;
        this.style = style;
        this.version = version;
        this.qqHelpHtml = qqHelpHtml;
        this.images = images;
        this.manageLeftTreeLeafIcon = manageLeftTreeLeafIcon;
        this.statisticsCode = statisticsCode;
        this.openResponsive = openResponsive;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.definitionOne = definitionOne;
        this.definitionTwo = definitionTwo;
    }
  //set\get方法
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystemCode() {
        return this.systemCode;
    }
    
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getWww() {
        return this.www;
    }
    
    public void setWww(String www) {
        this.www = www;
    }

    public String getLog() {
        return this.log;
    }
    
    public void setLog(String log) {
        this.log = log;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return this.keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getShortcuticon() {
        return this.shortcuticon;
    }
    
    public void setShortcuticon(String shortcuticon) {
        this.shortcuticon = shortcuticon;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcp() {
        return this.icp;
    }
    
    public void setIcp(String icp) {
        this.icp = icp;
    }

    public String getIsopen() {
        return this.isopen;
    }
    
    public void setIsopen(String isopen) {
        this.isopen = isopen;
    }

    public String getCloseMsg() {
        return this.closeMsg;
    }
    
    public void setCloseMsg(String closeMsg) {
        this.closeMsg = closeMsg;
    }

    public String getQq() {
        return this.qq;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getImageRootPath() {
        return this.imageRootPath;
    }
    
    public void setImageRootPath(String imageRootPath) {
        this.imageRootPath = imageRootPath;
    }

    public String getManageHttp() {
        return this.manageHttp;
    }
    
    public void setManageHttp(String manageHttp) {
        this.manageHttp = manageHttp;
    }

    public String getDefaultProductImg() {
        return this.defaultProductImg;
    }
    
    public void setDefaultProductImg(String defaultProductImg) {
        this.defaultProductImg = defaultProductImg;
    }

    public String getStyle() {
        return this.style;
    }
    
    public void setStyle(String style) {
        this.style = style;
    }

    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }

    public String getQqHelpHtml() {
        return this.qqHelpHtml;
    }
    
    public void setQqHelpHtml(String qqHelpHtml) {
        this.qqHelpHtml = qqHelpHtml;
    }

    public String getImages() {
        return this.images;
    }
    
    public void setImages(String images) {
        this.images = images;
    }

    public String getManageLeftTreeLeafIcon() {
        return this.manageLeftTreeLeafIcon;
    }
    
    public void setManageLeftTreeLeafIcon(String manageLeftTreeLeafIcon) {
        this.manageLeftTreeLeafIcon = manageLeftTreeLeafIcon;
    }

    public String getStatisticsCode() {
        return this.statisticsCode;
    }
    
    public void setStatisticsCode(String statisticsCode) {
        this.statisticsCode = statisticsCode;
    }

    public String getOpenResponsive() {
        return this.openResponsive;
    }
    
    public void setOpenResponsive(String openResponsive) {
        this.openResponsive = openResponsive;
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