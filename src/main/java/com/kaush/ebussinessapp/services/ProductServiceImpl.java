package com.kaush.ebussinessapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.ebussinessapp.entities.Product;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.ProductException;
import com.kaush.ebussinessapp.repos.CartRepository;
import com.kaush.ebussinessapp.repos.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		Product foundProduct = productRepo.findById(product.getProductId()).orElse(null);
		if(foundProduct != null) {
			return productRepo.save(product);
		}else {
			throw new ProductException("Product Not Found");
		}
	}

	
	@Override
	public Product findProductById(Integer id) throws ProductException {
		Product product = productRepo.findById(id).orElse(null);
		if(product != null) {
			return product;
		}else {
			throw new ProductException(id);
		}
	}

	@Override
	public List<Product> findAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public void deleteProductById(Integer id) throws ProductException {
		Product foundProduct = productRepo.findById(id).orElse(null);
		if(foundProduct != null) {
			productRepo.delete(foundProduct);
		}else {
			throw new ProductException(id);
		}
		
	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
	}

//	@Override
//	public Product addProductToCart(Product product) {
//		cartRepo.getProduct
//		return cartRepo.save(product);
//	}
//	
	


}
