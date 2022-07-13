package org.fooddelivery.onlinefood.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Table(name="orderdeatils")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class OrderDetails {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="orderDate")
	private LocalDateTime orderDate;
	
	@JsonIgnore
	@OneToOne
	private FoodCart Cart;
	
	@Column(name="orderStatus")
	private String orderStatus;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public FoodCart getCart() {
		return Cart;
	}

	public void setCart(FoodCart cart) {
		Cart = cart;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	} 
	
	  
}