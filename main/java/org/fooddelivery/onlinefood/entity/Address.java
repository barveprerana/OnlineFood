package org.fooddelivery.onlinefood.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Address {
	
	// define fields
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="addressId")
			private int addressId;
			
			@Column(name="buildingName")
			private String buildingName;
			
			@Column(name="streetNo")
			private String streetNo;
			
			@Column(name="area")
			private String area;
			
			@Column(name="city")
			private String city;
			
			@Column(name="state")
			private String state;
			
			@Column(name="country")
			private String country;
			
			@Column(name="pincode")
			private String pincode;

			public int getAddressId() {
				return addressId;
			}

			public void setAddressId(int addressId) {
				this.addressId = addressId;
			}

			public String getBuildingName() {
				return buildingName;
			}

			public void setBuildingName(String buildingName) {
				this.buildingName = buildingName;
			}

			public String getStreetNo() {
				return streetNo;
			}

			public void setStreetNo(String streetNo) {
				this.streetNo = streetNo;
			}

			public String getArea() {
				return area;
			}

			public void setArea(String area) {
				this.area = area;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getState() {
				return state;
			}

			public void setState(String state) {
				this.state = state;
			}

			public String getCountry() {
				return country;
			}

			public void setCountry(String country) {
				this.country = country;
			}

			public String getPincode() {
				return pincode;
			}

			public void setPincode(String pincode) {
				this.pincode = pincode;
			}
			

}