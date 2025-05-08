package com.BookMyStyle.Service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.BookMyStyle.Model.Category;
import com.BookMyStyle.Payload.DTO.SalonDTO;
import com.BookMyStyle.Repository.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepo categoryRepo;
	
	@Override
	public Category saveCategory(Category category, SalonDTO salonDTO) {
		Category newCategory = new Category();
		newCategory.setName(category.getName());
		newCategory.setSalonId(category.getSalonId());
		newCategory.setImage(category.getImage());
		return categoryRepo.save(newCategory);
	}

	@Override
	public Set<Category> getAllCategoriesBySalon(Long id) {
		return categoryRepo.findBySalonId(id);
	}

	@Override
	public Category getCategoryById(Long id) throws Exception {
		Category category = categoryRepo.findById(id).orElse(null);
		
		if(category == null) {
			throw new Exception("Category not exist with id " + id);
		}
		return category;
	}

	@Override
	public void deleteCategoryById(Long id, Long salonId) throws Exception {
		
		Category category = getCategoryById(id);
		if(!category.getSalonId().equals(salonId)) {
			throw new Exception("You don't have permission to delete this category");
		}
		categoryRepo.deleteById(id);
	}

}
