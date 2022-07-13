package org.fooddelivery.onlinefood.rest;
import java.util.List;

import org.fooddelivery.onlinefood.entity.Address;
import org.fooddelivery.onlinefood.service.IAddressService;
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
public class AddressRestController {

	private IAddressService iAddressService;
	
	@Autowired
	public AddressRestController(IAddressService theIAddressServicee) {
		iAddressService = theIAddressServicee;
	}
	
	@GetMapping("/addresss")
	public List<Address> findAll() {
		return iAddressService.findAll();
	}
	
	@GetMapping("/addresss/{addressId}")
	public Address getAddress(@PathVariable int addressId) {
		
		Address theAddress = iAddressService.findById(addressId);
		
		if (theAddress == null) {
			throw new RuntimeException("Address id not found - " + addressId);
		}
		
		return theAddress;
	}
	
	@PostMapping("/addresss")
	public Address addAddress(@RequestBody Address theAddress) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theAddress.setAddressId(0);
		
		iAddressService.save(theAddress);
		
		return theAddress;
	}
	
	
	@PutMapping("/addresss")
	public Address updatwAddress(@RequestBody Address theAddress) {
		
		iAddressService.save(theAddress);
		
		return theAddress;
	}
	

	@DeleteMapping("/addresss/{addressId}")
	public String deleteAddress(@PathVariable int addressId) {
		
		Address tempAddress = iAddressService.findById(addressId);
		
		// throw exception if null
		
		if (tempAddress == null) {
			throw new RuntimeException("Address id not found - " + addressId);
		}
		
		iAddressService.deleteById(addressId);
		
		return "Deleted Address id - " + addressId;
	}
	
}