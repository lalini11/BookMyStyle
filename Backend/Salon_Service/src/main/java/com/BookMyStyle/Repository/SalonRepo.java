package com.BookMyStyle.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BookMyStyle.Model.Salon;

public interface SalonRepo extends JpaRepository<Salon, Long> {

	Salon findByOwnerId(Long id);
	
	@Query("select s from Salon s where" +
			"(lower(s.city) like lower(concat('%', :keyword, '%')) OR " +
			"lower(s.city) like lower(concat('%', :keyword, '%')) OR " +
			"lower(s.city) like lower(concat('%', :keyword, '%')))" )
	List<Salon> searchSalons(@Param("keyword") String keyword);
}
