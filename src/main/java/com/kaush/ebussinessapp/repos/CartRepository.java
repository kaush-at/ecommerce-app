package com.kaush.ebussinessapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.ebussinessapp.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
