package com.kaush.ebussinessapp.services;

import com.kaush.ebussinessapp.entities.Address;
import com.kaush.ebussinessapp.exceptions.AddresException;

public interface AddressService {

	public Address save(Address address	) throws AddresException;
}
