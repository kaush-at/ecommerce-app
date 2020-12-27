package com.kaush.ebussinessapp.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.ebussinessapp.entities.Cart;
import com.kaush.ebussinessapp.entities.Product;
import com.kaush.ebussinessapp.repos.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;
	
	@Override
	public Cart addProductToCart(Cart cart) {
		Cart retrievedCart = cartRepo.findById(cart.getCartId()).orElse(null);
		if(retrievedCart != null) {
			retrievedCart.getProducts().add(cart.getProducts().get(0));
			return cartRepo.save(retrievedCart);
		}else {
			return cartRepo.save(cart);
		}
	}

	@Override
	public Cart deleteProductFromCart(Integer productid, Cart cart) {
		Iterator<Product> itr = cart.getProducts().iterator();
		while (itr.hasNext()) {
			Product p = itr.next();
			if(p.getProductId() == productid) {
				cart.getProducts().remove(p);
			}
		}
		return cart;
	}

}
