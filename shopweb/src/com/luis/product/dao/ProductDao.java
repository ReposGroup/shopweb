package com.luis.product.dao;

import org.springframework.stereotype.Repository;

import com.luis.base.dao.HibernateBaseDao;
import com.luis.product.model.Product;

@Repository
public class ProductDao extends HibernateBaseDao<Product, Integer>{
	
}
