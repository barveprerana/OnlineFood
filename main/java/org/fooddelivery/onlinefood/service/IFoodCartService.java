package org.fooddelivery.onlinefood.service;

import java.util.List;
import org.fooddelivery.onlinefood.entity.FoodCart;
import org.springframework.stereotype.Service;


@Service
public interface IFoodCartService {
	public List<FoodCart> findAll();
	
	public FoodCart findById(int theId);
	
	public void save(FoodCart theFoodCart);
	
	public void deleteById(int theId);
}