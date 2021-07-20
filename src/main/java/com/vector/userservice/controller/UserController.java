package com.vector.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vector.userservice.model.User;

import com.vector.userservice.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	private UserServiceImpl userServiceImpl;

	public UserController(UserServiceImpl userServiceImpl) {

		this.userServiceImpl = userServiceImpl;

	}
	
	@PostMapping("/user")
	public ResponseEntity saveUser(@RequestBody User user) throws Exception {
		log.info("Recieved request for creating a new user");
		String result = userServiceImpl.saveUser(user, false);
		return new ResponseEntity(result, HttpStatus.CREATED);
	} 
	
	
	@GetMapping("/user")
	public ResponseEntity getUser(String emailId) throws Exception {
		log.info("Recieved request for creating a new user");
		User result = userServiceImpl.getUser(emailId);
		return new ResponseEntity(result, HttpStatus.OK);
	} 

}
