package org.fooddelivery.onlinefood.rest;

import java.util.List;
import org.fooddelivery.onlinefood.entity.Restaurant;
import org.fooddelivery.onlinefood.service.IRestaurantService;
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
public class RestaurantRestController {

	private IRestaurantService iRestaurantService;
	
	@Autowired
	public RestaurantRestController(IRestaurantService theIRestaurantService) {
		iRestaurantService = theIRestaurantService;
	}
	
	@GetMapping("/rests")
	public List<Restaurant> findAll() {
		return iRestaurantService.findAll();
	}
	
	@GetMapping("/rests/{restId}")
	public Restaurant getRestaurant(@PathVariable int restId) {
		
		Restaurant theRestaurant = iRestaurantService.findById(restId);
		
		if (theRestaurant == null) {
			throw new RuntimeException("Restaurant id not found - " + restId);
		}
		
		return theRestaurant;
	}
	
	@PostMapping("/rests")
	public Restaurant addRestaurant(@RequestBody Restaurant theRestaurant) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theRestaurant.setRestaurantId(0);
		
		iRestaurantService.save(theRestaurant);
		
		return theRestaurant;
	}
	
	
	@PutMapping("/rests")
	public Restaurant updateRestaurant(@RequestBody Restaurant theRestaurant) {
		
		iRestaurantService.save(theRestaurant);
		
		return theRestaurant;
	}
	

	@DeleteMapping("/rests/{restId}")
	public String deleteRestaurant(@PathVariable int restId) {
		
		Restaurant tempRestaurant = iRestaurantService.findById(restId);
		
		// throw exception if null
		
		if (tempRestaurant == null) {
			throw new RuntimeException("Restaurant id not found - " + restId);
		}
		
		iRestaurantService.deleteById(restId);
		
		return "Deleted Restaurant id - " + restId;
	}
	
}
