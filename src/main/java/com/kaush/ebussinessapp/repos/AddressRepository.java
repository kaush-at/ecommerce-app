package com.kaush.ebussinessapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.ebussinessapp.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
