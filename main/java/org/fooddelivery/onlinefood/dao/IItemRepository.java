package org.fooddelivery.onlinefood.dao;


import org.fooddelivery.onlinefood.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item, Integer> {

	// that's it ... no need to write any code LOL!
	
}