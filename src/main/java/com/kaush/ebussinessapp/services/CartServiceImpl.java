package com.kaush.ebussinessapp.services;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.ebussinessapp.entities.Cart;
import com.kaush.ebussinessapp.entities.Product;
import com.kaush.ebussinessapp.entities.User;
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

	@Override
	public List<Product> getProductsByCartId(Integer id) {
		return  cartRepo.findProductsByCartId(id);
	}

	@Override
	public Cart addToCart(Cart cart, Product product) {

		// add first product to the cart
		if(cart.getCartId() == null) {
			Cart newCart = new Cart();
			// should send logged user
			cartRepo.save(newCart);
			newCart.setAddedDate(new Date());
			newCart.setEmail(cart.getUser().getEmail());
			newCart.getProducts().add(product);
			newCart.setUser(cart.getUser());
			return cartRepo.save(newCart);
		}else {
			cart.getProducts().add(product);
			cart.setAddedDate(new Date());
			return cartRepo.save(cart);
		}
		

	}

}
