package org.fooddelivery.onlinefood.service;

import java.util.List;
import java.util.Optional;


import org.fooddelivery.onlinefood.dao.IFoodCartRepository;
import org.fooddelivery.onlinefood.entity.FoodCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class IFoodCartServiceImpl implements IFoodCartService {

	private IFoodCartRepository iFoodCartRepository;
	
	@Autowired
	public IFoodCartServiceImpl(IFoodCartRepository theIFoodCartRepository) {
		iFoodCartRepository = theIFoodCartRepository;
	}
	
	@Override
	public List<FoodCart> findAll() {
		return iFoodCartRepository.findAll();
	}

	@Override
	public FoodCart findById(int theId) {
		Optional<FoodCart> result = iFoodCartRepository.findById(theId);
		
		FoodCart theFoodCart = null;
		
		if (result.isPresent()) {
			theFoodCart = result.get();
		}
		else {
			// we didn't find the Bill
			throw new RuntimeException("Did not find FoodCart id - " + theId);
		}
		
		return theFoodCart;
	}

	@Override
	public void save(FoodCart theFoodCart) {
		iFoodCartRepository.save(theFoodCart);
	}

	@Override
	public void deleteById(int theId) {
		iFoodCartRepository.deleteById(theId);
	}

}
