package com.kaush.ebussinessapp.services;

import com.kaush.ebussinessapp.entities.Cart;
import com.kaush.ebussinessapp.entities.Product;

public interface CartService {

	public Cart addProductToCart(Cart cart);

	public Cart deleteProductFromCart(Integer productid, Cart cart);
}
