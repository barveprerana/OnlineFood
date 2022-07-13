package org.fooddelivery.onlinefood.rest;


import java.util.List;

import org.fooddelivery.onlinefood.entity.Bill;
import org.fooddelivery.onlinefood.service.IBillService;
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
public class BillRestController {

	private IBillService iBillService;
	
	@Autowired
	public BillRestController(IBillService theIBillService) {
		iBillService = theIBillService;
	}
	
	@GetMapping("/bills")
	public List<Bill> findAll() {
		return iBillService.findAll();
	}
	
	@GetMapping("/bills/{billId}")
	public Bill getBill(@PathVariable int billId) {
		
		Bill theBill = iBillService.findById(billId);
		
		if (theBill == null) {
			throw new RuntimeException("Bill id not found - " + billId);
		}
		
		return theBill;
	}
	
	@PostMapping("/bills")
	public Bill addBill(@RequestBody Bill theBill) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theBill.setBillId(0);
		
		iBillService.save(theBill);
		
		return theBill;
	}
	
	
	@PutMapping("/bills")
	public Bill updateBill(@RequestBody Bill theBill) {
		
		iBillService.save(theBill);
		
		return theBill;
	}
	

	@DeleteMapping("/bills/{billId}")
	public String deleteBill(@PathVariable int billId) {
		
		Bill tempBill = iBillService.findById(billId);
		
		// throw exception if null
		
		if (tempBill == null) {
			throw new RuntimeException("Bill id not found - " + billId);
		}
		
		iBillService.deleteById(billId);
		
		return "Deleted Bill id - " + billId;
	}
	
}
