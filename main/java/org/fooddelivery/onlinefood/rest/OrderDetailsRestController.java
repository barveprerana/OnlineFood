package org.fooddelivery.onlinefood.rest;
import java.util.List;

import org.fooddelivery.onlinefood.entity.OrderDetails;
import org.fooddelivery.onlinefood.service.IOrderDetailsService;
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
public class OrderDetailsRestController {

	private IOrderDetailsService iOrderDetailsService;
	
	@Autowired
	public OrderDetailsRestController(IOrderDetailsService theIOrderDetailsServicee) {
		iOrderDetailsService = theIOrderDetailsServicee;
	}
	
	@GetMapping("/orders")
	public List<OrderDetails> findAll() {
		return iOrderDetailsService.findAll();
	}
	
	@GetMapping("/orders/{orderId}")
	public OrderDetails getOrderDetails(@PathVariable int orderId) {
		
		OrderDetails theOrderDetails = iOrderDetailsService.findById(orderId);
		
		if (theOrderDetails == null) {
			throw new RuntimeException("OrderDetails id not found - " + orderId);
		}
		
		return theOrderDetails;
	}
	
	@PostMapping("/orders")
	public OrderDetails addOrderDetails(@RequestBody OrderDetails theOrderDetails) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theOrderDetails.setOrderId(0);
		
		iOrderDetailsService.save(theOrderDetails);
		
		return theOrderDetails;
	}
	
	
	@PutMapping("/orders")
	public OrderDetails updateOrderDetails(@RequestBody OrderDetails theOrderDetails) {
		
		iOrderDetailsService.save(theOrderDetails);
		
		return theOrderDetails;
	}
	

	@DeleteMapping("/orders/{orderId}")
	public String deleteOrderDetails(@PathVariable int orderId) {
		
		OrderDetails tempOrderDetails = iOrderDetailsService.findById(orderId);
		
		// throw exception if null
		
		if (tempOrderDetails == null) {
			throw new RuntimeException("OrderDetails id not found - " + orderId);
		}
		
		iOrderDetailsService.deleteById(orderId);
		
		return "Deleted OrderDetails id - " + orderId;
	}
	
}