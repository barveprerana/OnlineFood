package org.fooddelivery.onlinefood.rest;

import java.util.List;
import org.fooddelivery.onlinefood.entity.Login;
import org.fooddelivery.onlinefood.service.ILoginService;
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
public class LoginRestController {

	private ILoginService iLoginService;
	
	@Autowired
	public LoginRestController(ILoginService theILoginService) {
		iLoginService = theILoginService;
	}
	
	@GetMapping("/logins")
	public List<Login> findAll() {
		return iLoginService.findAll();
	}
	
	@GetMapping("/logins/{loginId}")
	public Login getLogin(@PathVariable int loginId) {
		
		Login theLogin = iLoginService.findById(loginId);
		
		if (theLogin == null) {
			throw new RuntimeException("Login id not found - " + loginId);
		}
		
		return theLogin;
	}
	
	@PostMapping("/logins")
	public Login addLogin(@RequestBody Login theLogin) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theLogin.setUserid(0);
		
		iLoginService.save(theLogin);
		
		return theLogin;
	}
	
	
	@PutMapping("/logins")
	public Login updateLogin(@RequestBody Login theLogin) {
		
		iLoginService.save(theLogin);
		
		return theLogin;
	}
	

	@DeleteMapping("/logins/{loginId}")
	public String deleteLogin(@PathVariable int loginId) {
		
		Login tempLogin = iLoginService.findById(loginId);
		
		// throw exception if null
		
		if (tempLogin == null) {
			throw new RuntimeException("Login id not found - " + loginId);
		}
		
		iLoginService.deleteById(loginId);
		
		return "Deleted Login id - " + loginId;
	}
	
}
