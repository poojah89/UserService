package com.vector.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		String result = userServiceImpl.saveUser(user, false,null);
		return new ResponseEntity(result, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/user/{email}")
	public ResponseEntity updateUser(@RequestBody User user, @PathVariable String email) throws Exception {
		log.info("Recieved request for updating an existing user");
		String result = userServiceImpl.saveUser(user, true, email);
		return new ResponseEntity(result, HttpStatus.NO_CONTENT);
	} 
	
	
	@GetMapping("/user/{email}")
	public ResponseEntity getUser(@PathVariable String email) throws Exception {
		log.info("Recieved request for creating a new user");
		User result = userServiceImpl.getUser(email);
		return new ResponseEntity(result, HttpStatus.OK);
	} 
	
	@DeleteMapping("/user/{email}")
	public ResponseEntity deleteUser(@PathVariable String email) throws Exception {
		log.info("Recieved request for deleting an existing user");
		String result = userServiceImpl.deleteUser(email);
		return new ResponseEntity(result, HttpStatus.NO_CONTENT);
	} 

}
