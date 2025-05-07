package com.BookMyStyle.Service;

import java.util.List;

import com.BookMyStyle.Model.Salon;
import com.BookMyStyle.Payload.DTO.SalonDTO;
import com.BookMyStyle.Payload.DTO.UserDTO;

public interface SalonService {

	Salon createSalon(SalonDTO salon, UserDTO user);
	
	Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception;
	
	List<Salon> getAllSalons();
	
	Salon getSalonById(Long salonId) throws Exception;
	
	Salon getSalonByOwnerId(Long ownerId);
	
	List<Salon> searchSalonByCity(String city);
}
