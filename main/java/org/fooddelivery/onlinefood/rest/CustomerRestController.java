package org.fooddelivery.onlinefood.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.fooddelivery.onlinefood.entity.Customer;
import org.fooddelivery.onlinefood.service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private ICustomerService iCustomerService;
	
	@Autowired
	public CustomerRestController(ICustomerService theICustomerService) {
		iCustomerService = theICustomerService;
	}
	
	// expose "/customer" and return list of customer
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return iCustomerService.findAll();
	}

	// add mapping for GET /customer/{customerId}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = iCustomerService.findById(customerId);
		
		if (theCustomer == null) {
			throw new RuntimeException("Customer id not found - " + customerId);
		}
		
		return theCustomer;
	}
	
	// add mapping for POST /customers - add new customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theCustomer.setCustomerId(0);
		
		iCustomerService.save(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for PUT /customers - update existing customer
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		iCustomerService.save(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = iCustomerService.findById(customerId);
		
		// throw exception if null
		
		if (tempCustomer == null) {
			throw new RuntimeException("Customer id not found - " + customerId);
		}
		
		iCustomerService.deleteById(customerId);
		
		return "Deleted customer id - " + customerId;
	}
	
}