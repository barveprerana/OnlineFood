package org.fooddelivery.onlinefood.service;



import java.util.List;
import java.util.Optional;

import org.fooddelivery.onlinefood.dao.ILoginRepository;

import org.fooddelivery.onlinefood.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ILoginServiceImpl implements ILoginService {

	private ILoginRepository iLoginRepository;
	
	@Autowired
	public ILoginServiceImpl(ILoginRepository theILoginRepository) {
		iLoginRepository = theILoginRepository;
	}
	
	@Override
	public List<Login> findAll() {
		return iLoginRepository.findAll();
	}

	@Override
	public Login findById(int theId) {
		Optional<Login> result = iLoginRepository.findById(theId);
		
		Login theLogin = null;
		
		if (result.isPresent()) {
			theLogin = result.get();
		}
		else {
			// we didn't find the Bill
			throw new RuntimeException("Did not find Login id - " + theId);
		}
		
		return theLogin;
	}

	@Override
	public void save(Login theLogin) {
		iLoginRepository.save(theLogin);
	}

	@Override
	public void deleteById(int theId) {
		iLoginRepository.deleteById(theId);
	}
}