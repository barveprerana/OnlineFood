package org.fooddelivery.onlinefood.dao;



import org.fooddelivery.onlinefood.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {

	// that's it ... no need to write any code LOL!
	
}