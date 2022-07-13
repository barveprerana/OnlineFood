package org.fooddelivery.onlinefood.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="item")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Item {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itemId")
	private int itemId;
	
	@Column(name="itemName")
	private String itemName;
	
	@OneToOne
	private Category category;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="cost")
	private double cost;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })           
	@JoinTable(name = "restaurant_item",
    joinColumns = { @JoinColumn(name = "restaurant_id") },
    inverseJoinColumns = { @JoinColumn(name = "item_id") })
	@JsonIgnore

	private List<Restaurant> restaurant=new ArrayList<>();

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}
	
	
	

	

}