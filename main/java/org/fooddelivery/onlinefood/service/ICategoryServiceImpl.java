package org.fooddelivery.onlinefood.service;
import java.util.List;
import java.util.Optional;
import org.fooddelivery.onlinefood.dao.ICategoryRepository;
import org.fooddelivery.onlinefood.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICategoryServiceImpl implements ICategoryService {

	private ICategoryRepository iCategoryRepository;
	
	@Autowired
	public ICategoryServiceImpl(ICategoryRepository theICategoryRepository) {
		iCategoryRepository = theICategoryRepository;
	}
	
	@Override
	public List<Category> findAll() {
		return iCategoryRepository.findAll();
	}

	@Override
	public Category findById(int theId) {
		Optional<Category> result = iCategoryRepository.findById(theId);
		
		Category theCategory = null;
		
		if (result.isPresent()) {
			theCategory = result.get();
		}
		else {
			// we didn't find the Bill
			throw new RuntimeException("Did not find Category id - " + theId);
		}
		
		return theCategory;
	}

	@Override
	public void save(Category theCategory) {
		iCategoryRepository.save(theCategory);
	}

	@Override
	public void deleteById(int theId) {
		iCategoryRepository.deleteById(theId);
	}
}