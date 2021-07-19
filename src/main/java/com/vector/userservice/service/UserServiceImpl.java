package com.vector.userservice.service;

import org.springframework.stereotype.Service;

import com.vector.userservice.model.User;
import com.vector.userservice.model.entity.UserEntity;
import com.vector.userservice.repository.UserDataRestRepository;

@Service
public class UserServiceImpl {
	
	private UserDataRestRepository userDataRestRepository;
	
	public UserServiceImpl(UserDataRestRepository userDataRestRepository) {
		this.userDataRestRepository = userDataRestRepository;
		
	}
	
	public String saveUser(final User user, boolean Update) throws Exception {
		
		try {
			UserEntity userobj = new UserEntity();
		
		userobj.setEmailId(user.getEmailId());
		userobj.setFirstName(user.getFirstName());
		userobj.setLastName(user.getLastName());
		userobj.setPassword(user.getPassword());
		
		UserEntity result = userDataRestRepository.save(userobj);
		
		}
		
		catch (Exception ex){
			throw new Exception(ex.getMessage());
		}
		return "User created successfully";
	}
	

}
