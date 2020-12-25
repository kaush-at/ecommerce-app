package com.kaush.ebussinessapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.ebussinessapp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
