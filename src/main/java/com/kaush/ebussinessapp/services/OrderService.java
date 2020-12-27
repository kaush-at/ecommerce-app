package com.kaush.ebussinessapp.services;

import java.util.List;

import com.kaush.ebussinessapp.entities.Ordertbl;
import com.kaush.ebussinessapp.exceptions.OrderException;

public interface OrderService {

	public Ordertbl findOrderById(Integer id) throws OrderException;

	public List<Ordertbl> findAllOrdersByUserId(Integer userId);

	public Ordertbl createOrder(Ordertbl ordertbl) throws OrderException;

	public List<Ordertbl> getAllOrders();
}
