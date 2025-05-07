package com.BookMyStyle.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BookMyStyle.Exception.UserException;
import com.BookMyStyle.Model.User;
import com.BookMyStyle.Repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;
	
	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserById(Long id) throws UserException {
		Optional<User> otp = userRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		throw new UserException("User Not Found");
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(Long id) throws UserException {
		Optional<User> otp = userRepo.findById(id);
		if(otp.isEmpty()) {
			throw new UserException("User Not found with id " + id);
		}
		
		userRepo.deleteById(otp.get().getId());

	}

	@Override
	public User updateUser(Long id, User user) throws UserException {
		Optional<User> otp = userRepo.findById(id);
		if(otp.isEmpty()) {
			throw new UserException("User Not found with id" + id);
		}
		User existingUser = otp.get();
		
		existingUser.setFullName(user.getFullName());
		existingUser.setUserName(user.getUserName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhone(user.getPhone());
		existingUser.setRole(user.getRole());
		existingUser.setPassword(user.getPassword());
		
		return userRepo.save(existingUser);
	}

}
