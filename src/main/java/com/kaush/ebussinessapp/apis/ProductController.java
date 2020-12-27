package com.kaush.ebussinessapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaush.ebussinessapp.entities.Product;
import com.kaush.ebussinessapp.exceptions.ProductException;
import com.kaush.ebussinessapp.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		return productService.findAllProducts();
	}

	@DeleteMapping("/delete/{id}")
	public String DeleteProductById(@PathVariable  Integer id) throws ProductException {
		productService.deleteProductById(id);
		return "Product deleted";
	}
	
	@PutMapping("/editProduct")
	public Product updateProduct(@RequestBody Product product) throws ProductException {
		return productService.updateProduct(product);
	}
	
}
