package com.BookMyStyle.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BookMyStyle.Model.Salon;
import com.BookMyStyle.Payload.DTO.SalonDTO;
import com.BookMyStyle.Payload.DTO.UserDTO;
import com.BookMyStyle.Repository.SalonRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

	private final SalonRepo salonRepo;
	
	@Override
	public Salon createSalon(SalonDTO req, UserDTO user) {
		Salon salon = new Salon();
		salon.setName(req.getName());
		salon.setImages(req.getImages());
		salon.setAddress(req.getAddress());
		salon.setCity(req.getCity());
		salon.setEmail(req.getEmail());
		salon.setPhone(req.getPhone());
		salon.setOwnerId(user.getId());
		salon.setOpenTime(req.getOpenTime());
		salon.setCloseTime(req.getCloseTime());
		return salonRepo.save(salon);
	}

	@Override
	public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception {
		Salon existingSalon = salonRepo.findById(salonId).orElse(null);
		if(existingSalon != null && salon.getOwnerId().equals(user.getId())) {
			existingSalon.setName(salon.getName());
			existingSalon.setImages(salon.getImages());
			existingSalon.setAddress(salon.getAddress());
			existingSalon.setCity(salon.getCity());
			existingSalon.setEmail(salon.getEmail());
			existingSalon.setPhone(salon.getPhone());
			existingSalon.setOwnerId(user.getId());
			existingSalon.setOpenTime(salon.getOpenTime());
			existingSalon.setCloseTime(salon.getCloseTime());
			
			return salonRepo.save(existingSalon);
		}
		throw new Exception("Salon not Exist");
	}

	@Override
	public List<Salon> getAllSalons() {
		return salonRepo.findAll();
	}

	@Override
	public Salon getSalonById(Long salonId) throws Exception {
		Salon salon = salonRepo.findById(salonId).orElse(null);
		if(salon == null) {
			throw new Exception("Salon not exist"); 
		}
		return salon;
	}

	@Override
	public Salon getSalonByOwnerId(Long ownerId) {
		return salonRepo.findByOwnerId(ownerId);
	}

	@Override
	public List<Salon> searchSalonByCity(String city) {
		return salonRepo.searchSalons(city);
	}

}
