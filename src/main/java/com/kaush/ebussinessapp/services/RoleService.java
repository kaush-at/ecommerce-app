package com.kaush.ebussinessapp.services;

import com.kaush.ebussinessapp.entities.Role;
import com.kaush.ebussinessapp.exceptions.UserRoleException;

public interface RoleService {

	Role addUserRole(Role role) throws UserRoleException;
	
	Role findRoleIdByRoleName(String roleName);
}
