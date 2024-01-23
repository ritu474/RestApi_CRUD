package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductService {

	Product createProduct(Product product);
	
	Product updateProduct(Product product,int id);
	
	List<Product> getAllProduct();
	
	Product getAProduct(int id);
	
	String deleteProduct(int id);
	
	
	
}
