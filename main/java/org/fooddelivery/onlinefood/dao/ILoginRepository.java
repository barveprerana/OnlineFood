package org.fooddelivery.onlinefood.dao;

import org.fooddelivery.onlinefood.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginRepository extends JpaRepository<Login, Integer> {

	// that's it ... no need to write any code LOL!
	
}
