package com.BookMyStyle.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping
	public String HomeControllerHandler() {
		return "User MicroService for Salon Booking System";
	}
}
