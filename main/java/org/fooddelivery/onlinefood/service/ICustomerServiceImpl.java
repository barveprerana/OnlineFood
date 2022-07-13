package org.fooddelivery.onlinefood.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.fooddelivery.onlinefood.dao.ICustomerRepository;
import org.fooddelivery.onlinefood.entity.Customer;

@Service
public class ICustomerServiceImpl implements ICustomerService 
{

	private ICustomerRepository iCustomerRepository;
	
	@Autowired
	public ICustomerServiceImpl(ICustomerRepository theICustomerRepository) {
		iCustomerRepository = theICustomerRepository;
	}
	
	@Override
	public List<Customer> findAll() {
		return iCustomerRepository.findAll();
	}

	@Override
	public Customer findById(int theId) {
		Optional<Customer> result = iCustomerRepository.findById(theId);
		
		Customer theCustomer = null;
		
		if (result.isPresent()) {
			theCustomer = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		iCustomerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		iCustomerRepository.deleteById(theId);
	}

}