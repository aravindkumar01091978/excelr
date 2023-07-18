package com.excelr.ecommerce.controller;
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

import com.excelr.ecommerce.entity.OrderData;
import com.excelr.ecommerce.entity.Product;
import com.excelr.ecommerce.repository.OrderRepository;
import com.excelr.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/ecommerce/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@GetMapping("/date-range/{productId}")
	public List<OrderData> getOrdersByOrderDateRange(@PathVariable int productId, 
			@RequestParam String start, @RequestParam String end){
		Date startDate= Date.valueOf(start);
		Date endDate=Date.valueOf(end);
		
		List<OrderData> ordersByDateRange = 
				orderRepository.findByOrderDateBetween(startDate, endDate);
		List<OrderData> ordersByDateRangeAndProductId  = new ArrayList<>();
		for(OrderData order:ordersByDateRange) {
			if(order.getProduct().getProductId() == productId) {
				ordersByDateRangeAndProductId.add(order);
			}
		}
		return ordersByDateRangeAndProductId;	
	}

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
	
	@GetMapping("/category")
	public List<Product> getProductsByCategory(@RequestParam String category){
		return productRepository.findByCategory(category);
	}

}
