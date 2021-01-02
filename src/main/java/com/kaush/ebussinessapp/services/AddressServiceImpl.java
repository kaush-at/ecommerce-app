package com.kaush.ebussinessapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.ebussinessapp.entities.Address;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.AddresException;
import com.kaush.ebussinessapp.repos.AddressRepository;
import com.kaush.ebussinessapp.repos.UserRepository;


@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Address save(Address address) throws AddresException {
		Address savedAddress =  addressRepo.save(address);
		if(null != address.getUser().getUserId() ) {
			User foundUser = userRepo.findById(address.getUser().getUserId()).get();
			foundUser.setAddress(savedAddress);
			userRepo.save(foundUser); 
			savedAddress.setUser(foundUser);
		}else {
			throw new AddresException("User Id must set before save address");
		}
		return savedAddress;
	}

}
