package com.luis.product.model;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product  implements java.io.Serializable {
	 //BigDecimal  Date
	 private static final long serialVersionUID = -3814243370218926603L;
	 private Integer id;
     private String name;
     private String introduce;
     private Double price;
     private Double nowPrice;
     private String picture;
     private String isnew;
     private String sale;
     private Integer hit;
     private Integer status;
     private String productHtml;
     private String maxPicture;
     private String images;
     private String catalogId;
     private Integer sellcount;
     private Integer stock;
     private String searchKey;
     private String title;
     private String description;
     private String keywords;
     private String activityId;
     private String unit;
     private Integer score;
     private String isTimePromotion;
     private String giftId;
     private Timestamp createtime;
     private Timestamp updatetime;
     private String createBy;
     private String updateBy;
     private String definitionOne;
     private String definitionTwo;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }
    
    public Product(String name, String introduce, Double price, Double nowPrice, String picture, String isnew, String sale, Integer hit, Integer status, String productHtml, String maxPicture, String images, String catalogId, Integer sellcount, Integer stock, String searchKey, String title, String description, String keywords, String activityId, String unit, Integer score, String isTimePromotion, String giftId, Timestamp createtime, Timestamp updatetime, String createBy, String updateBy, String definitionOne, String definitionTwo) {
        this.name = name;
        this.introduce = introduce;
        this.price = price;
        this.nowPrice = nowPrice;
        this.picture = picture;
        this.isnew = isnew;
        this.sale = sale;
        this.hit = hit;
        this.status = status;
        this.productHtml = productHtml;
        this.maxPicture = maxPicture;
        this.images = images;
        this.catalogId = catalogId;
        this.sellcount = sellcount;
        this.stock = stock;
        this.searchKey = searchKey;
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.activityId = activityId;
        this.unit = unit;
        this.score = score;
        this.isTimePromotion = isTimePromotion;
        this.giftId = giftId;
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

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return this.introduce;
    }
    
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getNowPrice() {
        return this.nowPrice;
    }
    
    public void setNowPrice(Double nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIsnew() {
        return this.isnew;
    }
    
    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public String getSale() {
        return this.sale;
    }
    
    public void setSale(String sale) {
        this.sale = sale;
    }

    public Integer getHit() {
        return this.hit;
    }
    
    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProductHtml() {
        return this.productHtml;
    }
    
    public void setProductHtml(String productHtml) {
        this.productHtml = productHtml;
    }

    public String getMaxPicture() {
        return this.maxPicture;
    }
    
    public void setMaxPicture(String maxPicture) {
        this.maxPicture = maxPicture;
    }

    public String getImages() {
        return this.images;
    }
    
    public void setImages(String images) {
        this.images = images;
    }

    public String getCatalogId() {
        return this.catalogId;
    }
    
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public Integer getSellcount() {
        return this.sellcount;
    }
    
    public void setSellcount(Integer sellcount) {
        this.sellcount = sellcount;
    }

    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getSearchKey() {
        return this.searchKey;
    }
    
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
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

    public String getActivityId() {
        return this.activityId;
    }
    
    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getScore() {
        return this.score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIsTimePromotion() {
        return this.isTimePromotion;
    }
    
    public void setIsTimePromotion(String isTimePromotion) {
        this.isTimePromotion = isTimePromotion;
    }

    public String getGiftId() {
        return this.giftId;
    }
    
    public void setGiftId(String giftId) {
        this.giftId = giftId;
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