package org.fooddelivery.onlinefood.service;

import java.util.List;
import org.fooddelivery.onlinefood.entity.Customer;
import org.springframework.stereotype.Service;
@Service
public interface ICustomerService {
	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
}