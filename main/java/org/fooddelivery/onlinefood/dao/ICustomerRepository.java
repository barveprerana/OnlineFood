package org.fooddelivery.onlinefood.dao;

import org.fooddelivery.onlinefood.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	// that's it ... no need to write any code LOL!
	
}