package org.fooddelivery.onlinefood.service;

import java.util.List;
import java.util.Optional;

import org.fooddelivery.onlinefood.dao.IAddressRepository;

import org.fooddelivery.onlinefood.entity.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class IAddressServiceImpl implements IAddressService {

	private IAddressRepository iAddressRepository;
	
	@Autowired
	public IAddressServiceImpl(IAddressRepository theIAddressRepository) {
		iAddressRepository = theIAddressRepository;
	}
	
	@Override
	public List<Address> findAll() {
		return iAddressRepository.findAll();
	}

	@Override
	public Address findById(int theId) {
		Optional<Address> result = iAddressRepository.findById(theId);
		
		Address theAddress = null;
		
		if (result.isPresent()) {
			theAddress = result.get();
		}
		else {
			// we didn't find the Bill
			throw new RuntimeException("Did not find Address id - " + theId);
		}
		
		return theAddress;
	}

	@Override
	public void save(Address theAddress) {
		iAddressRepository.save(theAddress);
	}

	@Override
	public void deleteById(int theId) {
		iAddressRepository.deleteById(theId);
	}
}