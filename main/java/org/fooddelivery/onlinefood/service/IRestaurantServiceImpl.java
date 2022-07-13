package org.fooddelivery.onlinefood.service;

import java.util.List;
import java.util.Optional;
import org.fooddelivery.onlinefood.dao.IRestaurantRepository;
import org.fooddelivery.onlinefood.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class IRestaurantServiceImpl implements IRestaurantService {

	private IRestaurantRepository iRestaurantRepository;
	
	@Autowired
	public IRestaurantServiceImpl(IRestaurantRepository theIRestaurantRepository) {
		iRestaurantRepository = theIRestaurantRepository;
	}
	
	@Override
	public List<Restaurant> findAll() {
		return iRestaurantRepository.findAll();
	}

	@Override
	public Restaurant findById(int theId) {
		Optional<Restaurant> result = iRestaurantRepository.findById(theId);
		
		Restaurant theRestaurant = null;
		
		if (result.isPresent()) {
			theRestaurant = result.get();
		}
		else {
			// we didn't find the Bill
			throw new RuntimeException("Did not find Restaurant id - " + theId);
		}
		
		return theRestaurant;
	}

	@Override
	public void save(Restaurant theRestaurant) {
		iRestaurantRepository.save(theRestaurant);
	}

	@Override
	public void deleteById(int theId) {
		iRestaurantRepository.deleteById(theId);
	}
}