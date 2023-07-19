package com.excelr.productservice.entity;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderData {

	@Id
	private int orderId;
	
	@OneToOne
	@JoinColumn  	// Join with Primary Key of UserData Table
	private UserData user;
	
	@OneToOne
	@JoinColumn				// Join with Product Table
	private Product product;
	
	private Date orderDate;
	private int quantity;
	private double totalPrice;
	private String shipmentStatus;
		
	public OrderData() {
	}

	public OrderData(int orderId, UserData user, Product product, Date orderDate, int quantity, double totalPrice,
			String shipmentStatus) {
		this.orderId = orderId;
		this.user = user;
		this.product = product;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.shipmentStatus = shipmentStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	@Override
	public String toString() {
		return "OrderData [orderId=" + orderId + ", user=" + user + ", product=" + product + ", orderDate=" + orderDate
				+ ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", shipmentStatus=" + shipmentStatus + "]";
	}
	
	
	
}
