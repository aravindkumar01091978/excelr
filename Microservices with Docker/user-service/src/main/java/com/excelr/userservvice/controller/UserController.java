package com.excelr.userservvice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.excelr.userservvice.entity.Product;
import com.excelr.userservvice.entity.UserData;
import com.excelr.userservvice.repository.UserRepository;



@RestController
@RequestMapping("/ecommerce/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	// Microservice call to get Product details based on Category
	@GetMapping("/product/category/{category}")
	public List<Product> getProductBasedOnCategory(@PathVariable String category){
		String targetUrl = "http://product-service/ecommerce/product/category";
		
		//RestTemplate restTemplate = new RestTemplate();
		
		return (List<Product>) restTemplate.getForObject(targetUrl+"/"+category, List.class);
	}
	
	// REST end-point to return all Users
	@GetMapping
	public List<UserData> getAllUsers(){
		return (List<UserData>) userRepository.findAll();
	}

	// REST end-point to return User by ID
	@GetMapping("/{userId}")
	public UserData getByUserId(@PathVariable int userId) {
		return userRepository.findById(userId).get();
	}
	
	// REST end-point to create a new User
	@PostMapping
	public String addUserData(@RequestBody UserData user) {
		userRepository.save(user);
		return "User saved successfully with Id: "+user.getUserId();
	}
	


}
