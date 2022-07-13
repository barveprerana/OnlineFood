package org.fooddelivery.onlinefood.service;

import java.util.List;
import java.util.Optional;
import org.fooddelivery.onlinefood.dao.IItemRepository;
import org.fooddelivery.onlinefood.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IItemServiceImpl implements IItemService {

	private IItemRepository iItemRepository;
	
	@Autowired
	public IItemServiceImpl(IItemRepository theIItemRepository) {
		iItemRepository = theIItemRepository;
	}
	
	@Override
	public List<Item> findAll() {
		return iItemRepository.findAll();
	}

	@Override
	public Item findById(int theId) {
		Optional<Item> result = iItemRepository.findById(theId);
		
		Item theItem = null;
		
		if (result.isPresent()) {
			theItem = result.get();
		}
		else {
			// we didn't find the Bill
			throw new RuntimeException("Did not find Item id - " + theId);
		}
		
		return theItem;
	}

	@Override
	public void save(Item theItem) {
		iItemRepository.save(theItem);
	}

	@Override
	public void deleteById(int theId) {
		iItemRepository.deleteById(theId);
	}
}