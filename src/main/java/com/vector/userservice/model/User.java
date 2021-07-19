package com.vector.userservice.model;

import lombok.Data;

@Data
public class User {
	
	//private Long id;

	private String emailId;

	private String password;

	private String firstName;

	private String lastName;
}
