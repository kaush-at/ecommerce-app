package com.kaush.ebussinessapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.ebussinessapp.entities.Address;
import com.kaush.ebussinessapp.repos.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepo;
	
	@Override
	public Address save(Address address) {
		return addressRepo.save(address);
	}

}
