package com.vector.userservice.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vector.userservice.model.User;
import com.vector.userservice.model.entity.UserEntity;

@RepositoryRestResource(path = "user", collectionResourceRel = "user")
public interface UserDataRestRepository extends PagingAndSortingRepository<UserEntity,Integer> {

	Optional<UserEntity> findByEmailId(String emailId);

	//User save(User userobj);
	
}
