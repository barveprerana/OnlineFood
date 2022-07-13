package org.fooddelivery.onlinefood.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="category")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Category {
	// define fields
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="catId")
			private int catId;
			
			@Column(name="categoryName")
			private String categoryName;

			public int getCatId() {
				return catId;
			}

			public void setCatId(int catId) {
				this.catId = catId;
			}

			public String getCategoryName() {
				return categoryName;
			}

			public void setCategoryName(String categoryName) {
				this.categoryName = categoryName;
			}

			
			
			
			
			
		
}