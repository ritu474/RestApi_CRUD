package com.example.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product, int id) {
		
		Optional<Product> productDb=this.productRepository.findById(id);
		
		if(productDb.isPresent())
		{
			
		
		Product _product=productRepository.findById(id).get();
		_product.setName(product.getName());
		_product.setPrice(product.getPrice());
		_product.setDescription(product.getDescription());
		return productRepository.save(_product);
		
		}
		
		else
		{
			throw new ResourceNotFoundException("Record not found with id : "+id);
		}
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getAProduct(int id) {
		
		Optional<Product> productDb=this.productRepository.findById(id);
		
		if(productDb.isPresent())
		{
		return productRepository.findById(id).get();
		}
		else
		{
			throw new ResourceNotFoundException("Record not found with id "+id);
		}
		
	}

	@Override
	public String deleteProduct(int id) {
		
		Optional<Product> productDb=this.productRepository.findById(id);
		if(productDb.isPresent())
		{
		productRepository.deleteById(id);
		return "The product with ID "+id+" has been deleted";
		}
		else
		{
			throw new ResourceNotFoundException("Record not found with id "+id);
		}
	}

}
