package com.kaush.ebussinessapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.ebussinessapp.entities.Cart;
import com.kaush.ebussinessapp.entities.Product;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Product> findProductsByCartId(Integer id);
}
