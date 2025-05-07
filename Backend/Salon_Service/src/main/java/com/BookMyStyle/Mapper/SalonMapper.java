package com.BookMyStyle.Mapper;

import com.BookMyStyle.Model.Salon;
import com.BookMyStyle.Payload.DTO.SalonDTO;

public class SalonMapper {

	public static SalonDTO mapToDTO(Salon salon) {
		SalonDTO salonDTO = new SalonDTO();
		salonDTO.setId(salon.getId());
		salonDTO.setName(salon.getName());
		salonDTO.setAddress(salon.getAddress());
		salonDTO.setCity(salon.getCity());
		salonDTO.setEmail(salon.getEmail());
		salonDTO.setImages(salon.getImages());
		salonDTO.setPhone(salon.getPhone());
		salonDTO.setOwnerId(salon.getOwnerId());
		salonDTO.setOpenTime(salon.getOpenTime());
		salonDTO.setCloseTime(salon.getCloseTime());
		return salonDTO;
	} 
}
