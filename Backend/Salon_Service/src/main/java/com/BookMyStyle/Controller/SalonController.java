package com.BookMyStyle.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookMyStyle.Mapper.SalonMapper;
import com.BookMyStyle.Model.Salon;
import com.BookMyStyle.Payload.DTO.SalonDTO;
import com.BookMyStyle.Payload.DTO.UserDTO;
import com.BookMyStyle.Service.SalonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

	private final SalonService salonService;
	
	@PostMapping
	public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO){
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);
		
		Salon salon = salonService.createSalon(salonDTO, userDTO);
		SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);
		
		return ResponseEntity.ok(salonDTO1);				
	}
	
	
	@PatchMapping("/{salonId}")
	public ResponseEntity<SalonDTO> updateSalon(
			@PathVariable Long salonId,
			@RequestBody SalonDTO salonDTO) throws Exception{
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);
		
		Salon salon = salonService.updateSalon(salonDTO, userDTO, salonId);
		SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);
		
		return ResponseEntity.ok(salonDTO1);				
	}
	
	
	@GetMapping
	public ResponseEntity<List<SalonDTO>> getSalons(){
		
		List<Salon> salons = salonService.getAllSalons();
		
		List<SalonDTO> salonDTOS = salons.stream().map((salon) -> {
			SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
			return salonDTO;
		}).toList();
		
		return ResponseEntity.ok(salonDTOS);
	}
	
	
	@GetMapping("/{salonId}")
	public ResponseEntity<SalonDTO> getSalonById(@PathVariable Long salonId) throws Exception{
		
		Salon salon = salonService.getSalonById(salonId);
		SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
		
		return ResponseEntity.ok(salonDTO);		
	}
	
	// http://localhost:5002/api/salons/search?city=pune
	@GetMapping("/search")
	public ResponseEntity<List<SalonDTO>> searchSalons(
			@RequestParam("city") String city) throws Exception{
		
		List<Salon> salons = salonService.searchSalonByCity(city);
		
		List<SalonDTO> salonDTOS = salons.stream().map((salon) -> {
			SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
			return salonDTO;
		}).toList();
		
		return ResponseEntity.ok(salonDTOS);
	}
	
	@GetMapping("/owner")//owner id grape from the jwt token
	public ResponseEntity<SalonDTO> getSalonByOwnerId(@PathVariable Long ownerId) throws Exception{
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1L);//static data for owner id
		
		Salon salon = salonService.getSalonByOwnerId(userDTO.getId());
		SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
		
		return ResponseEntity.ok(salonDTO);		
	}
}
