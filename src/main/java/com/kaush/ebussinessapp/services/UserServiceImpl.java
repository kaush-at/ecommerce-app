package com.kaush.ebussinessapp.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.ebussinessapp.dtos.LoginDataDTO;
import com.kaush.ebussinessapp.entities.Role;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.UserNotFoundException;
import com.kaush.ebussinessapp.exceptions.UserRoleException;
import com.kaush.ebussinessapp.repos.RoleRepository;
import com.kaush.ebussinessapp.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;
	
	@Override
	public User addUser(User user) throws Exception {

		
		// set default role as Customer
		if(user.getRole() == null ) {
			
			if(roleRepo.findByRoleName("Customer") == null) {
				throw new UserRoleException("User role must be set first");
			}else {
				user.setRole(roleRepo.findByRoleName("Customer"));
			}
			
		}
	
		// check user email already there in the system
		User retrievedUser = userRepo.findUserByEmail(user.getEmail());
		if(retrievedUser != null) {
			throw new UserNotFoundException("This email id already use in another user");
		}
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User findUserById(Integer userId) throws UserNotFoundException {
		User retrievedUser = userRepo.findById(userId).orElse(null);
		if( retrievedUser != null ) {
			return retrievedUser;
		}else {
			throw new UserNotFoundException("User not found");
		}
	}

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepo.deleteById(id);;
	}

	@Override
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}

	@Override
	public User findUserByLoginDetails(LoginDataDTO loginDto) throws UserNotFoundException {
		User foundUser = userRepo.findUserByEmail(loginDto.getEmail());
		if(foundUser != null && loginDto.getPassword().equals(foundUser.getPassword())) {
			return foundUser;
		}
		 throw new UserNotFoundException("Please check your username and password");  
	}

}
