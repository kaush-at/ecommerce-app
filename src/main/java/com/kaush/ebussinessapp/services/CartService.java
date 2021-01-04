package com.kaush.ebussinessapp.services;

import java.util.List;

import com.kaush.ebussinessapp.entities.Cart;
import com.kaush.ebussinessapp.entities.Product;

public interface CartService {

	public Cart addProductToCart(Cart cart);

	public Cart deleteProductFromCart(Integer productid, Cart cart);
	
	public List<Product> getProductsByCartId(Integer id);

	public Cart addToCart(Cart cart,Product product); 
}
