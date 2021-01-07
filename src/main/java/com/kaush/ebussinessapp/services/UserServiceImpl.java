package com.kaush.ebussinessapp.services;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.ebussinessapp.dtos.LoginDataDTO;
import com.kaush.ebussinessapp.entities.Role;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.UserNotFoundException;
import com.kaush.ebussinessapp.repos.RoleRepository;
import com.kaush.ebussinessapp.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;
	
	@Override
	public User addUser(User user) throws UserNotFoundException, RoleNotFoundException {
		
		// set default role as Customer
		Role role = new Role();
		role.setRoleName("Customer");
		user.setRole(role);
		
		if(roleRepo.findByRoleName("Customer") == null) {
			roleRepo.save(role);
		}
		
		
		// prevent add duplicate user roles to the role table
		Role existingRole = roleRepo.findByRoleName(user.getRole().getRoleName());
		if(existingRole != null) {
			user.getRole().setRoleId(existingRole.getRoleId());
		}else{
			throw new RoleNotFoundException("Please check the role table and add the user roles first");
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
