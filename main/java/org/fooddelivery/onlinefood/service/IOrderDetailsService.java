package org.fooddelivery.onlinefood.service;


import java.util.List;

import org.fooddelivery.onlinefood.entity.OrderDetails;
import org.springframework.stereotype.Service;

@Service
public interface IOrderDetailsService {
	public List<OrderDetails> findAll();
	
	public OrderDetails findById(int theId);
	
	public void save(OrderDetails theOrderDetails);
	
	public void deleteById(int theId);
}