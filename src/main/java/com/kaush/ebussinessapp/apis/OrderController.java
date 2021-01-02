package com.kaush.ebussinessapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaush.ebussinessapp.entities.Address;
import com.kaush.ebussinessapp.entities.Ordertbl;
import com.kaush.ebussinessapp.exceptions.OrderException;
import com.kaush.ebussinessapp.services.AddressService;
import com.kaush.ebussinessapp.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/save")
	public Ordertbl createOrder(@RequestBody Ordertbl ordertbl) throws OrderException {
		return orderService.createOrder(ordertbl);
	}
	
	
	@GetMapping("/{id}")
	public Ordertbl getOrderById(@PathVariable Integer id) throws OrderException {
		return orderService.findOrderById(id);
	}
	
	// this api is for Admin to see all orders
	@GetMapping("/getAllOrders")
	public List<Ordertbl> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	// this api is for 
	@GetMapping("/getAllOrders/{userId}")
	public List<Ordertbl> getAllOrders(@PathVariable Integer userId){
		return  orderService.findAllOrdersByUserId(userId);
	}
	
	@PostMapping("/createAddress")
	public Address saveAddress(@RequestBody Address adderss) {
		return adderss;
	}
	
}
