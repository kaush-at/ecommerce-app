package com.kaush.ebussinessapp.services;

import java.util.List;

import com.kaush.ebussinessapp.entities.Product;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.ProductException;

public interface ProductService {

	public Product addProduct(Product product);
	
	public Product updateProduct(Product product) throws ProductException;
	
	public Product findProductById(Integer id) throws ProductException;
	
	public List<Product> findAllProducts();
	
	public void deleteProductById(Integer id) throws ProductException;
	
	public void deleteAllProducts();
	
	//public Product addProductToCart(Product product);
	
}
