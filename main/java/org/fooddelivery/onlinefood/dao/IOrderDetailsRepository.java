package org.fooddelivery.onlinefood.dao;


import org.fooddelivery.onlinefood.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

	// that's it ... no need to write any code LOL!
	
}