package com.BookMyStyle.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookMyStyle.Model.User;
import com.BookMyStyle.Repository.UserRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping
	public User createUser(@RequestBody @Valid User user) {
		return userRepo.save(user);
	}
	
	@GetMapping
	public List<User> getUser() {
		return userRepo.findAll();
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") Long id) throws Exception{
		Optional<User> otp = userRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		throw new Exception("User Not Found");
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
		Optional<User> otp = userRepo.findById(id);
		if(otp.isEmpty()) {
			throw new Exception("User Not found with id" + id);
		}
		User existingUser = otp.get();
		
		existingUser.setFullName(user.getFullName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhone(user.getPhone());
		existingUser.setRole(user.getRole());
		
		return userRepo.save(existingUser);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable Long id) throws Exception {
		Optional<User> otp = userRepo.findById(id);
		if(otp.isEmpty()) {
			throw new Exception("User Not found with id" + id);
		}
		
		userRepo.deleteById(otp.get().getId());
		return "User Deleted";
	}
}
