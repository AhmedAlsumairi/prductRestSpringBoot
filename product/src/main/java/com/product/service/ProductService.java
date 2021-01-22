package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.ResourceNotFoundException;
import com.product.models.Product;
import com.product.repository.ProductRepository;
@Service
public class ProductService{

	@Autowired 
	private ProductRepository repository;
	
	// get All Products method
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	// get Product By ID
	public Product getProductById(Long productID) throws ResourceNotFoundException {
		Product product = repository.findById(productID).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + productID));
		return product;
		
	}
	
	
	// Add Product Method
	public Product  saveProduct(Product product) {
		return repository.save(product);
		
	}
	
	// Add Product Method
		public String  deleteProduct(Product product) {
			repository.delete(product);
			return "deleted";
			
		}

}
