package com.BookMyStyle.Service;

import java.util.Set;

import com.BookMyStyle.Model.Category;
import com.BookMyStyle.Payload.DTO.SalonDTO;

public interface CategoryService {

	Category saveCategory(Category category, SalonDTO salonDTO);
	Set<Category> getAllCategoriesBySalon(Long id);
	Category getCategoryById(Long id) throws Exception;
	void deleteCategoryById(Long id, Long salonId) throws Exception;
}
