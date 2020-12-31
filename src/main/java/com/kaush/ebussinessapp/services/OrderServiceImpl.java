package com.kaush.ebussinessapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.ebussinessapp.entities.Ordertbl;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.OrderException;
import com.kaush.ebussinessapp.repos.OrdertblRepository;
import com.kaush.ebussinessapp.repos.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrdertblRepository orderRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public Ordertbl findOrderById(Integer id) throws OrderException {
		Ordertbl foundOrder = orderRepo.findById(id).orElse(null);
		if(foundOrder!=null) {
			return foundOrder;
		}else {
			throw new OrderException(id);
		}
	}

	@Override
	public List<Ordertbl> findAllOrdersByUserId(Integer userId) {
		return orderRepo.findByUserUserId(userId);
	}

	@Override
	public Ordertbl createOrder(Ordertbl ordertbl) throws OrderException {
		/*
		 *	when place the order we can get the user id and send that user id with the order create request
		 *  but by mistake UI developer forget to bind User Id this will handle it.
		 */
		if(ordertbl.getUser() == null) {
			throw new OrderException("Please Bind the user before create order");
		}
		
		if(ordertbl.getUser().getUserId() != null) {
			Integer userId = ordertbl.getUser().getUserId();
			User userRecieved = userRepo.findById(userId).orElse(null);
			
			if(userRecieved != null) {
				if(!(userRecieved.getRole().getRoleName().equals("Admin"))) {
					return orderRepo.save(ordertbl);
				}else {
					throw new OrderException("As Admin you cannot place the order");
				}
			}else {
				throw new OrderException("Your account not found. Please register to place orders");
			}
		}else {
			throw new OrderException("User Id cannot be null");
		}
		
	}

	
	@Override
	public List<Ordertbl> getAllOrders() {
		return orderRepo.findAll();
	}

}
