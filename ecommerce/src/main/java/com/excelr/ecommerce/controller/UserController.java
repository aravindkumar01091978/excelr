package com.excelr.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ecommerce.entity.Product;
import com.excelr.ecommerce.entity.UserData;
import com.excelr.ecommerce.repository.ProductRepository;
import com.excelr.ecommerce.repository.UserRepository;

@RestController
@RequestMapping("/ecommerce/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
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
	
	// REST end-point to get Product info based on categories (Request parameter)	
	@GetMapping("/product")
	public List<Product> getProductsBasedOnCategory(@RequestParam String category){
		ProductController productController = new ProductController();
		return productController.getProductsByCategory(category);
	}

}
