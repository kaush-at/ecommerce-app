package com.kaush.ebussinessapp.services;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import com.kaush.ebussinessapp.dtos.LoginDataDTO;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.UserNotFoundException;


public interface UserService {

	public User addUser(User user) throws UserNotFoundException, RoleNotFoundException;
	
	public User updateUser(User user);
	
	public User findUserById(Integer id) throws UserNotFoundException;
	
	public List<User> findAllUsers();
	
	public void deleteUserById(Integer id);
	
	public void deleteAllUsers();
	
	public User findUserByLoginDetails(LoginDataDTO loginDto) throws UserNotFoundException;
	
}
