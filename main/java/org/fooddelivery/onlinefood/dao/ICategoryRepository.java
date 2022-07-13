package org.fooddelivery.onlinefood.dao;



import org.fooddelivery.onlinefood.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

	// that's it ... no need to write any code LOL!
	
}