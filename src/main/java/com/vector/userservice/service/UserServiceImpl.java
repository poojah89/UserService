package com.vector.userservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.userservice.exception.InternalException;
import com.vector.userservice.model.User;
import com.vector.userservice.model.entity.UserEntity;
import com.vector.userservice.repository.UserDataRestRepository;

@Service
public class UserServiceImpl implements UserService{

	private UserDataRestRepository userDataRestRepository;

	public UserServiceImpl(UserDataRestRepository userDataRestRepository) {
		this.userDataRestRepository = userDataRestRepository;

	}
	
	@Override
	public String saveUser(final User user, boolean update, String emailId) throws InternalException {

		UserEntity userobj = new UserEntity();
		String resultMessage = "";

		

			if (!update) {

				userobj.setEmail(user.getEmail());
				userobj.setFirstName(user.getFirstName());
				userobj.setLastName(user.getLastName());
				userobj.setPassword(user.getPassword());

				UserEntity result = userDataRestRepository.save(userobj);
				resultMessage = "The user was created successfully.";

			}

			if (update) {

				Optional<UserEntity> userEntity = userDataRestRepository.findByEmailId(emailId);

				if (userEntity.isPresent()) {

					// if(user.getEmailId())
					userobj.setEmail(userEntity.get().getEmail());
					userobj.setPassword(user.getPassword());
					userobj.setFirstName(user.getFirstName());
					userobj.setLastName(user.getLastName());

					UserEntity result = userDataRestRepository.save(userobj);
					resultMessage = "The user was updated successfully.";

				} else {
					throw new InternalException("400", "User with email address does not exists - " + emailId);
				}

			}
		

		
		return resultMessage;
	}
	
	@Override
	public User getUser(String emailId) throws InternalException {

		User user = new User();

		Optional<UserEntity> userEntity = userDataRestRepository.findByEmailId(emailId);

		if (userEntity.isPresent()) {

			user.setEmail(userEntity.get().getEmail());
			user.setPassword(userEntity.get().getPassword());
			user.setFirstName(userEntity.get().getFirstName());
			user.setLastName(userEntity.get().getLastName());

		}

		else {
			System.out.println("test1");
			throw new InternalException("400", "User with email address does not exists - " + emailId);
		}

		/*
		 * catch (Exception ex) { System.out.println("test2"); throw new
		 * InternalException("400",ex.getMessage()); }
		 */

		return user;

	}

	

	@Transactional
	@Override
	public String deleteUser(final String email) throws InternalException {

		String message = "The user was deleted successfully.";

		try {

			Optional<UserEntity> userEntityExist = userDataRestRepository.findByEmailId(email);

			if (!userEntityExist.isPresent()) {

				throw new InternalException("400", "User does not exist or already deleted!");

			}

			UserEntity userEntity = new UserEntity();
			userEntity.setEmail(email);
			userDataRestRepository.deleteByEmailId(email);
		} catch (Exception ex) {
			throw new InternalException("400", "User does not exist or already deleted!");
		}

		return message;

	}

}
