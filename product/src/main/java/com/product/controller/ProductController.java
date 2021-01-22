package com.product.controller;



	import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.product.exception.ResourceNotFoundException;
import com.product.models.Product;
import com.product.repository.ProductRepository;
    import com.product.service.ProductService;

	@RestController
	public class ProductController {
		

		
		
		@Autowired
		private ProductService service;
		
	
		
		// Get All Products Reource
		@GetMapping("/products")
		public List<Product> getProducts() {
			return service.getProducts();
		}
		
		
		// Get Product Based on ID Reource
		@GetMapping("/product/{id}")
		public ResponseEntity<Product> getProduct(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
			Product product = service.getProductById(productId);
			return ResponseEntity.ok().body(product);
		}
		
		// Create Product Resource
		@PostMapping("/product")
		public Product createProduct( @RequestBody Product product) {
			return service.saveProduct(product);
		}
		
		
		// Update Product  resource
		@PutMapping("/product/{id}")
		public ResponseEntity<Product> updateEmployee(@PathVariable(value = "id") Long productId,
				 @RequestBody Product productDetails) throws ResourceNotFoundException  {
			Product product = service.getProductById(productId);
			product.setName(productDetails.getName());
			final Product updatedProduct = service.saveProduct(product);
			return ResponseEntity.ok(updatedProduct);
		}
		
		
		@DeleteMapping("/product/{id}")
		public String deleteEmployee(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
			Product product = service.getProductById(productId);
			service.deleteProduct(product);
			return "deleted";
		}

	}



