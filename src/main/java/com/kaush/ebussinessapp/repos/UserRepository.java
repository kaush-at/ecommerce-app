package com.kaush.ebussinessapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.ebussinessapp.dtos.UserRolesDTO;
import com.kaush.ebussinessapp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
//
//	@Query(nativeQuery = true, value="select ")
//	public LoginDataDto findUserCredentials(String username);
	
	public User findByusername(String username);
	
//	select * role_id from user_roles where user_id = id;
	public UserRolesDTO findUserRolesByUserId(Integer id);

	public User findUserByEmail(String email);
	
	
}
