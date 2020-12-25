package com.kaush.ebussinessapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.ebussinessapp.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
