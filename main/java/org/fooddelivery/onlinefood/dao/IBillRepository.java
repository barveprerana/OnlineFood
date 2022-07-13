package org.fooddelivery.onlinefood.dao;

import org.fooddelivery.onlinefood.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill, Integer> {

	// that's it ... no need to write any code LOL!
	
}

