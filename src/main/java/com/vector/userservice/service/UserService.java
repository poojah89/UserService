package com.vector.userservice.service;

import com.vector.userservice.exception.InternalException;
import com.vector.userservice.model.User;

public interface UserService {
	
	public String saveUser(final User user, boolean update, String emailId) throws InternalException;
	
	public User getUser(String emailId) throws InternalException;
	
	public String deleteUser(final String email) throws InternalException;

}
