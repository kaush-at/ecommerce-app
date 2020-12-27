package com.kaush.ebussinessapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.ebussinessapp.dtos.RolesDTO;
import com.kaush.ebussinessapp.entities.Role;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.UserNotFoundException;
import com.kaush.ebussinessapp.exceptions.UserRoleException;
import com.kaush.ebussinessapp.repos.RoleRepository;

@Service	
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserService userService;
	
//	@Override
//	public String addUserRole(RolesDTO rolesDTO) throws UserNotFoundException {
//		Role role = new Role();
//		if(rolesDTO.getRoleName() != null) {
//			role.setRoleName(rolesDTO.getRoleName());
//		}else {
//			throw new UserNotFoundException("User role cannot be Null"); 
//		}
//		// get the user id from save request
//		Integer userId = rolesDTO.getUserId();
//		
//		if( userId != null) {
//			User u = userService.findUserById(userId);
//			if(u != null)  {
//				// userservice.getuserRoles -> userroles list eka ganna one perticular user ta
//				//userService.findUsers
//				List<User> usrList = new ArrayList<User>();
//				usrList.add(u);
//				//role.setUsers(usrList);
//			}else {
//				throw new UserNotFoundException("User not found"); 
//			}
//		}else {
//			throw new UserNotFoundException("User id cannot be null");
//		}
//		roleRepo.save(role);
//		return "User role added to role table";
//	}

	@Override
	public Role findRoleIdByRoleName(String roleName) {
		return roleRepo.findByRoleName(roleName);
	}

	@Override
	public Role addUserRole(Role role) throws UserRoleException {
		if(roleRepo.findByRoleName(role.getRoleName())!= null) {
			throw new UserRoleException("User role already exists");
		}else {
			return roleRepo.save(role);
		}
	}
	
}
