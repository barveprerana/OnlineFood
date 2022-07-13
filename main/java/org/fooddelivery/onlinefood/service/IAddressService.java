package org.fooddelivery.onlinefood.service;
import java.util.List;

import org.fooddelivery.onlinefood.entity.Address;

import org.springframework.stereotype.Service;

@Service
public interface IAddressService {
	public List<Address> findAll();
	
	public Address findById(int theId);
	
	public void save(Address theAddress);
	
	public void deleteById(int theId);
}