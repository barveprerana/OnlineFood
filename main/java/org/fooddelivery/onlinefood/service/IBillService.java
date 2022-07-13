package org.fooddelivery.onlinefood.service;

import java.util.List;

import org.fooddelivery.onlinefood.entity.Bill;
import org.springframework.stereotype.Service;

@Service
public interface IBillService {
	public List<Bill> findAll();
	
	public Bill findById(int theId);
	
	public void save(Bill theBill);
	
	public void deleteById(int theId);
}
