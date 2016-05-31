--创建管理员表1
DROP TABLE IF EXISTS adminUser;
CREATE TABLE adminUser (
  adminId  number(16) NOT NULL PRIMARY KEY,
  userName varchar2(255) DEFAULT NULL,
  passWord varchar2(255) DEFAULT NULL
);
create sequence admin_seq;

--创建普通用户表2
DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
  userId number(16) NOT NULL PRIMARY KEY,
  userName varchar2(255) DEFAULT NULL,
  passWord varchar2(255) DEFAULT NULL,
  email varchar2(255) DEFAULT NULL,
  phone varchar2(255) DEFAULT NULL,
  address varchar2(255) DEFAULT NULL,
  state number(16) DEFAULT 0,
  code varchar2(128) DEFAULT NULL
);
create sequence user_seq;

--创建订单表3
DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders(
  orderId number(16) NOT NULL PRIMARY KEY,
  name varchar2(255) DEFAULT NULL,
  total number(10,2) DEFAULT NULL,
  ordertime Date DEFAULT sysdate,
  state number(16) DEFAULT NULL,
  phone varchar2(255) DEFAULT NULL,
  address varchar2(255) DEFAULT NULL,
  userId number(16) references Users(userId)
);
create sequence orders_seq;

--创建订单项表4
DROP TABLE IF EXISTS orderItem;
CREATE TABLE orderItem (
  ItemId number(16) NOT NULL PRIMARY KEY ,
  amount number(32) DEFAULT NULL,
  subtotal number(10,2) DEFAULT NULL,
  orderId number(16) references Orders(orderId),
  productId number(16) references Product(productId)
); 
create sequence orderItem_seq;

--创建产品种类表5
DROP TABLE IF EXISTS Category;
CREATE TABLE Category(
  categoryId number(16) NOT NULL  PRIMARY KEY,
  cname varchar2(255) DEFAULT NULL,
  cdesc varchar2(255) DEFAULT NULL
);
create sequence category_seq;

--创建产品表6
DROP TABLE IF EXISTS Product;
CREATE TABLE Product(
  productId number(16) NOT NULL PRIMARY KEY ,
  pname varchar2(255) DEFAULT NULL,
  mprice number(16,2) DEFAULT NULL,
  sprice number(16,2) DEFAULT NULL,
  image varchar2(255) DEFAULT NULL,
  pdesc varchar2(255) DEFAULT NULL,
  ishot varchar2(16) DEFAULT NULL,
  pdate Date DEFAULT sysdate,
  categoryId number(10) references Category(categoryId)
);
create sequence product_seq;
