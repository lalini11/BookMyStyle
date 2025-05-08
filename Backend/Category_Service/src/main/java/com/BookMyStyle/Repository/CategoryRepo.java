package com.BookMyStyle.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookMyStyle.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	Set<Category> findBySalonId(Long salonId);
}
