package com.luis.product.service;

import java.util.List;

import com.luis.product.model.Product;

public interface ProductService {
	
	public void save(Product product);//保存
	
	public void deleteById(Integer id);//删除
	
	public Product getById(Integer id);//根据iD查询
	
	public List<Product> findAll();//查询所有
}
