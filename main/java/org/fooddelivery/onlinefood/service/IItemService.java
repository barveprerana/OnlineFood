package org.fooddelivery.onlinefood.service;

import java.util.List;
import org.fooddelivery.onlinefood.entity.Item;
import org.springframework.stereotype.Service;

@Service
public interface IItemService {
	public List<Item> findAll();
	
	public Item findById(int theId);
	
	public void save(Item theItem);
	
	public void deleteById(int theId);
}