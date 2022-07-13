package org.fooddelivery.onlinefood.dao;


import org.fooddelivery.onlinefood.entity.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodCartRepository extends JpaRepository<FoodCart, Integer> {

	// that's it ... no need to write any code LOL!
	
}