package org.fooddelivery.onlinefood.rest;
import java.util.List;

import org.fooddelivery.onlinefood.entity.Category;
import org.fooddelivery.onlinefood.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

	private ICategoryService iCategoryService;
	
	@Autowired
	public CategoryRestController(ICategoryService theICategoryService) {
		iCategoryService = theICategoryService;
	}
	
	@GetMapping("/categorys")
	public List<Category> findAll() {
		return iCategoryService.findAll();
	}
	
	@GetMapping("/categorys/{categoryId}")
	public Category getCategory(@PathVariable int categoryId) {
		
		Category theCategory = iCategoryService.findById(categoryId);
		
		if (theCategory == null) {
			throw new RuntimeException("Category id not found - " + categoryId);
		}
		
		return theCategory;
	}
	
	@PostMapping("/categorys")
	public Category addCategory(@RequestBody Category theCategory) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theCategory.setCatId(0);
		
		iCategoryService.save(theCategory);
		
		return theCategory;
	}
	
	
	@PutMapping("/categorys")
	public Category updateCategory(@RequestBody Category theCategory) {
		
		iCategoryService.save(theCategory);
		
		return theCategory;
	}
	

	@DeleteMapping("/categorys/{categoryId}")
	public String deleteCategory(@PathVariable int categoryId) {
		
		Category tempCategory = iCategoryService.findById(categoryId);
		
		// throw exception if null
		
		if (tempCategory == null) {
			throw new RuntimeException("Category id not found - " + categoryId);
		}
		
		iCategoryService.deleteById(categoryId);
		
		return "Deleted Category id - " + categoryId;
	}
	
}