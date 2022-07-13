package org.fooddelivery.onlinefood.service;

import java.util.List;
import java.util.Optional;

import org.fooddelivery.onlinefood.dao.IOrderDetailsRepository;
import org.fooddelivery.onlinefood.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IOrderDetailsServiceImpl implements IOrderDetailsService 
{

	private IOrderDetailsRepository iOrderDetailsRepository;
	
	@Autowired
	public IOrderDetailsServiceImpl(IOrderDetailsRepository theIOrderDetailsRepository) {
		iOrderDetailsRepository = theIOrderDetailsRepository;
	}
	
	@Override
	public List<OrderDetails> findAll() {
		return iOrderDetailsRepository.findAll();
	}

	@Override
	public OrderDetails findById(int theId) {
		Optional<OrderDetails> result = iOrderDetailsRepository.findById(theId);
		
		OrderDetails theOrderDetails = null;
		
		if (result.isPresent()) {
			theOrderDetails = result.get();
		}
		else {
			// we didn't find the OrderDetails
			throw new RuntimeException("Did not find OrderDetails id - " + theId);
		}
		
		return theOrderDetails;
	}

	@Override
	public void save(OrderDetails theOrderDetails) {
		iOrderDetailsRepository.save(theOrderDetails);
	}

	@Override
	public void deleteById(int theId) {
		iOrderDetailsRepository.deleteById(theId);
	}

}