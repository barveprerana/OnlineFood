package org.fooddelivery.onlinefood.service;

import java.util.List;
import org.fooddelivery.onlinefood.entity.Login;
import org.springframework.stereotype.Service;


@Service
public interface ILoginService {
	public List<Login> findAll();
	
	public Login findById(int theId);
	
	public void save(Login theLogin);
	
	public void deleteById(int theId);
}
