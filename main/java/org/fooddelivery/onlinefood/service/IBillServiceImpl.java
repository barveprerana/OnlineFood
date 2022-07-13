package org.fooddelivery.onlinefood.service;

import java.util.List;
import java.util.Optional;

import org.fooddelivery.onlinefood.dao.IBillRepository;
import org.fooddelivery.onlinefood.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class IBillServiceImpl implements IBillService {

	private IBillRepository iBillRepository;
	
	@Autowired
	public IBillServiceImpl(IBillRepository theIBillRepository) {
		iBillRepository = theIBillRepository;
	}
	
	@Override
	public List<Bill> findAll() {
		return iBillRepository.findAll();
	}

	@Override
	public Bill findById(int theId) {
		Optional<Bill> result = iBillRepository.findById(theId);
		
		Bill theBill = null;
		
		if (result.isPresent()) {
			theBill = result.get();
		}
		else {
			// we didn't find the Bill
			throw new RuntimeException("Did not find Bill id - " + theId);
		}
		
		return theBill;
	}

	@Override
	public void save(Bill theBill) {
		iBillRepository.save(theBill);
	}

	@Override
	public void deleteById(int theId) {
		iBillRepository.deleteById(theId);
	}

}
