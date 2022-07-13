package org.fooddelivery.onlinefood.entity;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="restaurant")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Restaurant {
	
	// define fields
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="restaurantId")
		private int restaurantId;
		
		@Column(name="restaurantName")
		private String restaurantName;
		
		@OneToOne
		private Address address;
		
		
		@ManyToMany(fetch = FetchType.LAZY,
	      cascade = {
	          CascadeType.MERGE
	      },
	      mappedBy = "restaurant")
		@JsonIgnore
		private List<Item> itemList=new ArrayList<>();
		
		@Column(name="managerName")
		private String managerName;
		
		@Column(name="contactNumber")
		private String contactNumber;

		public int getRestaurantId() {
			return restaurantId;
		}

		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}

		public String getRestaurantName() {
			return restaurantName;
		}

		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public List<Item> getItemList() {
			return itemList;
		}

		public void setItemList(List<Item> itemList) {
			this.itemList = itemList;
		}

		public String getManagerName() {
			return managerName;
		}

		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		
		
		

		
		
		
	
}