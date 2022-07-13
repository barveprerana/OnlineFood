package org.fooddelivery.onlinefood.service;

import java.util.List;

import org.fooddelivery.onlinefood.entity.Restaurant;
import org.springframework.stereotype.Service;

@Service
public interface IRestaurantService {
	public List<Restaurant> findAll();
	
	public Restaurant findById(int theId);
	
	public void save(Restaurant theRestaurant);
	
	public void deleteById(int theId);
}