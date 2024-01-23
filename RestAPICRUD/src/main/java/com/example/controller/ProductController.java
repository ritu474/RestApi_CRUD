package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value="/products")
	public Product createProductController(@RequestBody Product p)
	{
		return productService.createProduct(p);
	}
	
	@GetMapping(value="/products")
	public List<Product> getAllController()
	{
		return productService.getAllProduct();
	}
	
	@GetMapping(value="/products/{id}")
	public Product getAController(@PathVariable int id)
	{
		return productService.getAProduct(id);
	}
	
	@PutMapping(value="/products/{id}")
	public Product updateAProductController(@RequestBody Product p,@PathVariable int id)
	{
		return productService.updateProduct(p, id);
	}
	
	@DeleteMapping(value="/products/{id}")
	public String deleteAStudent(@PathVariable int id)
	{
		return productService.deleteProduct(id);
	}
	
	
	
}
