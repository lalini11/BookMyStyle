package com.BookMyStyle.Service;

import java.util.List;

import com.BookMyStyle.Exception.UserException;
import com.BookMyStyle.Model.User;

public interface UserService {
	
	User createUser(User user);
	User getUserById(Long id) throws UserException;
	List<User> getAllUsers();
	void deleteUser(Long id) throws UserException;
	User updateUser(Long id, User user) throws UserException;
	
}
