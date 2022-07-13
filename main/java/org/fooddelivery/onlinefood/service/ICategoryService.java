package org.fooddelivery.onlinefood.service;

import java.util.List;
import org.fooddelivery.onlinefood.entity.Category;
import org.springframework.stereotype.Service;


@Service
public interface ICategoryService {
	public List<Category> findAll();
	
	public Category findById(int theId);
	
	public void save(Category theCategory);
	
	public void deleteById(int theId);
}