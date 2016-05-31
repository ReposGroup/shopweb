--��������Ա��1
--DROP TABLE IF EXISTS adminUser;
CREATE TABLE adminUser (
  adminId  int identity(1,1)  PRIMARY KEY NOT NULL,
  userName varchar(255) DEFAULT NULL,
  passWord varchar(255) DEFAULT NULL
);

--������ͨ�û���2
--DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
  userId int identity(1,1) PRIMARY KEY NOT NULL,
  userName varchar(255) DEFAULT NULL,
  passWord varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  state int DEFAULT 0,
  code varchar(128) DEFAULT NULL
);

--����������3
--DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders(
  orderId int identity(1,1) PRIMARY KEY NOT NULL,
  name varchar(255) DEFAULT NULL,
  total int DEFAULT NULL,
  ordertime Date DEFAULT NULL,
  state int DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  userId int references Users(userId)
);

--������Ʒ�����5
--DROP TABLE IF EXISTS Category;
CREATE TABLE Category(
  categoryId int identity(1,1)  PRIMARY KEY NOT NULL,
  cname varchar(255) DEFAULT NULL,
  cdesc varchar(255) DEFAULT NULL
);

--������Ʒ��6
--DROP TABLE IF EXISTS Product;
CREATE TABLE Product(
  productId int identity(1,1) PRIMARY KEY NOT NULL,
  pname varchar(255) DEFAULT NULL,
  mprice int DEFAULT NULL,
  sprice int DEFAULT NULL,
  image varchar(255) DEFAULT NULL,
  pdesc varchar(255) DEFAULT NULL,
  ishot varchar(16) DEFAULT NULL,
  pdate Date DEFAULT NULL,
  categoryId int references Category(categoryId)
);

--�����������4
--DROP TABLE IF EXISTS orderItem;
CREATE TABLE orderItem (
  ItemId int identity(1,1)  PRIMARY KEY NOT NULL,
  amount int DEFAULT NULL,
  subtotal int DEFAULT NULL,
  orderId int references Orders(orderId),
  productId int references Product(productId)
); 