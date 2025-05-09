package com.BookMyStyle.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Salon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ElementCollection // create separate table for this
	private  List<String> images;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private Long ownerId;
	
	@Column(nullable = false)
	private LocalDateTime openTime;
	
	@Column(nullable = false)
	private LocalDateTime closeTime;
	
}
