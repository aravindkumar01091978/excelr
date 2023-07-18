package com.excelr.productservice.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.productservice.entity.Product;
import com.excelr.productservice.repository.ProductRepository;



@RestController
@RequestMapping("/ecommerce/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping
	public List<Product> getAllProducts(){
		return (List<Product>) productRepository.findAll();
		
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable int productId) {
		return productRepository.findById(productId).get();
	}
	
	@PostMapping
	public String addProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "Product saved successfully with Product Id: "+product.getProductId();
	}
	
	@GetMapping("/category/{category}")
	public List<Product> getProductsByCategory(@PathVariable String category){
		return productRepository.findByCategory(category);
	}

}
