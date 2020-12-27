package com.kaush.ebussinessapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.ebussinessapp.entities.Ordertbl;

public interface OrdertblRepository extends JpaRepository<Ordertbl, Integer> {

	public List<Ordertbl> findByUserUserId(Integer userId);
	
}
