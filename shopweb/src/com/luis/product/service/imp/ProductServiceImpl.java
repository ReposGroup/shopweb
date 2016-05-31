package com.luis.product.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luis.product.dao.ProductDao;
import com.luis.product.model.Product;
import com.luis.product.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public void save(Product product) {
		productDao.saveOrUpdate(product);
	}

	@Override
	public void deleteById(Integer id) {
		productDao.deleteById(id);
	}

	@Override
	public Product getById(Integer id) {
		return productDao.get(id);
	}

	@Override
	public List<Product> findAll() {
		return productDao.getAll();
	}
}
