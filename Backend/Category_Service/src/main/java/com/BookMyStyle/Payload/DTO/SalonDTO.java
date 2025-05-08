package com.BookMyStyle.Payload.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SalonDTO {

	private Long id;
	
	private String name;
	
	private  List<String> images;
	
	private String address;
	
	private String phone;
	
	private String email;
	
	private String city;
	
	private Long ownerId;
	
	private LocalDateTime openTime;
	
	private LocalDateTime closeTime;
}
