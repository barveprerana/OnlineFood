package org.fooddelivery.onlinefood.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Table(name="foodcart")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class FoodCart {
	// define fields
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="cartId")
		private int cartId;
		
		
		@OneToOne
		private Customer customer;
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }) 
		private List<Item> itemList;
		
		

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<Item> getItemList() {
			return itemList;
		}

		public void setItemList(List<Item> itemList) {
			this.itemList = itemList;
		}
		
		

}