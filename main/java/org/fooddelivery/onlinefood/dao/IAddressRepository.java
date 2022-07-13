package org.fooddelivery.onlinefood.dao;


import org.fooddelivery.onlinefood.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Integer> {

	// that's it ... no need to write any code LOL!
	
}