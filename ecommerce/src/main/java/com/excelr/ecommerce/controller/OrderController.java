package com.excelr.ecommerce.controller;

import java.sql.Date;
import java.text.ParseException;
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
import com.excelr.ecommerce.repository.OrderRepository;

@RestController
@RequestMapping("/ecommerce/order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping
	public List<OrderData> getAllOrders(){
		return (List<OrderData>) orderRepository.findAll();
	}
	
	@GetMapping("/orderId")
	public OrderData getByOrderId(@PathVariable int orderId) {
		return orderRepository.findById(orderId).get();
	}
	
	@PostMapping
	public String addOrderData(@RequestBody OrderData order) {
		orderRepository.save(order);
		return "Order Saved successfully "
				+ "with Order ID: "+order.getOrderId();
	}	
	
	@GetMapping("/date-range")
	public List<OrderData> getByDateRange(@RequestParam String start, 
			@RequestParam String end ) throws ParseException{
		Date startDate= Date.valueOf(start);
		Date endDate=Date.valueOf(end);
		return orderRepository.findByOrderDateBetween(startDate, endDate);
	}
}