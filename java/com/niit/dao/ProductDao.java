package com.niit.dao;

import java.util.List;

import com.niit.domain.Product;


public interface ProductDao {
	public boolean insert(Product product);

	
	public boolean update(Product product);

	public boolean delete (Product product);

	public Product getProductById(int id);

	public Product getProductByName(String name);

	public List<Product> list();
}
