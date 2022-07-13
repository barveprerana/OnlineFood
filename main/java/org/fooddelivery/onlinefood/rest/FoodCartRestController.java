package org.fooddelivery.onlinefood.rest;

import java.util.List;

import org.fooddelivery.onlinefood.entity.Address;
import org.fooddelivery.onlinefood.entity.FoodCart;
import org.fooddelivery.onlinefood.service.IFoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class FoodCartRestController {

	private IFoodCartService iFoodCartService;
	
	@Autowired
	public FoodCartRestController(IFoodCartService theIFoodCartService) {
		iFoodCartService = theIFoodCartService;
	}
	
	
	@GetMapping("/foodcarts")
	public List<FoodCart> findAll() {
		return iFoodCartService.findAll();
	}

	
	@GetMapping("/foodcarts/{foodcartId}")
	public FoodCart getFoodCart(@PathVariable int foodcartId) {
		
		FoodCart theFoodCart = iFoodCartService.findById(foodcartId);
		
		if (theFoodCart == null) {
			throw new RuntimeException("FoodCart id not found - " + foodcartId);
		}
		
		return theFoodCart;
	}
	
	
	
	@PostMapping("/foodcarts")
	public FoodCart addFoodCart(@RequestBody FoodCart theFoodCart) {
		
		
		theFoodCart.setCartId(0);
		
		iFoodCartService.save(theFoodCart);
		
		return theFoodCart;
	}
	
	
	
	@PutMapping("/foodcarts")
	public FoodCart updateFoodCart(@RequestBody FoodCart theFoodCart) {
		
		iFoodCartService.save(theFoodCart);
		
		return theFoodCart;
	}
	

	
	@DeleteMapping("/foodcarts/{foodcartId}")
	public String deleteFoodCart(@PathVariable int foodcartId) {
		
		FoodCart tempFoodCart = iFoodCartService.findById(foodcartId);
		
		// throw exception if null
		
		if (tempFoodCart == null) {
			throw new RuntimeException("FoodCart id not found - " + foodcartId);
		}
		
		iFoodCartService.deleteById(foodcartId);
		
		return "Deleted FoodCart id - " + foodcartId;
	}
	
}