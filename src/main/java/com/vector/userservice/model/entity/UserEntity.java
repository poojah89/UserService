package com.vector.userservice.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = -5256603351722268373L;
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * @Column(name = "id", updatable = true, nullable = false) private Long id;
	 * 
	 * @Column(name = "emailId", nullable = false, columnDefinition =
	 * "varchar(256)") private String emailId;
	 */
	@Id
	@Column(name = "emailId", nullable = false)
	private String emailId;
	
	@Column(name = "password", nullable = false, columnDefinition = "varchar(256)")
	private String password;
	
	@Column(name = "firstName", nullable = false, columnDefinition = "varchar(256)")
	private String firstName;
	
	@Column(name = "lastName", nullable = false, columnDefinition = "varchar(256)")
	private String lastName;
}
