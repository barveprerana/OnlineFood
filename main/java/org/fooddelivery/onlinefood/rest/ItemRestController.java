package org.fooddelivery.onlinefood.rest;

import java.util.List;
import org.fooddelivery.onlinefood.entity.Item;
import org.fooddelivery.onlinefood.service.IItemService;
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
public class ItemRestController {

	private IItemService iItemService;
	
	@Autowired
	public ItemRestController(IItemService theIItemService) {
		iItemService = theIItemService;
	}
	
	@GetMapping("/items")
	public List<Item> findAll() {
		return iItemService.findAll();
	}
	
	@GetMapping("/items/{itemId}")
	public Item getItem(@PathVariable int itemId) {
		
		Item theItem = iItemService.findById(itemId);
		
		if (theItem == null) {
			throw new RuntimeException("Bill id not found - " + itemId);
		}
		
		return theItem;
	}
	
	@PostMapping("/items")
	public Item addItem(@RequestBody Item theItem) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theItem.setItemId(0);
		
		iItemService.save(theItem);
		
		return theItem;
	}
	
	
	@PutMapping("/items")
	public Item updateItem(@RequestBody Item theItem) {
		
		iItemService.save(theItem);
		
		return theItem;
	}
	

	@DeleteMapping("/items/{itemId}")
	public String deleteItem(@PathVariable int itemId) {
		
		Item tempItem = iItemService.findById(itemId);
		
		// throw exception if null
		
		if (tempItem == null) {
			throw new RuntimeException("Item id not found - " + itemId);
		}
		
		iItemService.deleteById(itemId);
		
		return "Deleted Item id - " + itemId;
	}
	
}
