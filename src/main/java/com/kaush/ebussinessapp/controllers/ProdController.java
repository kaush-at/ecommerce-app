package com.kaush.ebussinessapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaush.ebussinessapp.entities.Cart;
import com.kaush.ebussinessapp.entities.Product;
import com.kaush.ebussinessapp.exceptions.ProductException;
import com.kaush.ebussinessapp.services.CartService;
import com.kaush.ebussinessapp.services.ProductService;

@Controller
public class ProdController {

	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	
	@RequestMapping("/addProduct")
	public String addProductPage(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}
	
	@RequestMapping("admin/saveProduct")
	public String addProduct(Model model, @Valid Product product, Errors errors) {
		if(errors.hasErrors()) {
			return "/register";
		}
		productService.addProduct(product);
		return "redirect:/addProduct";
	}
	
	@RequestMapping("/showAllProducts")
	public String showAllProducts(Model model) {
		model.addAttribute("productList", productService.findAllProducts());
		model.addAttribute("cart", new Cart());
		return "showProducts";
	}
	
	@PostMapping("/addToCart")
	public String addProductToCart(Model model, @Valid Cart cart, @Valid Product product,Errors errors) {
		if(errors.hasErrors()) {
			return "redirect:/showProducts";
		}
		
		cartService.addToCart(cart, product);
		return "showProducts";
	}
	
	@GetMapping("/viewProduct/{id}")
	public String viewProductById(Model model,@PathVariable Integer id) throws ProductException {
		Product prod = productService.findProductById(id);
		model.addAttribute("product", prod);
		return "productPage";
		
	}
	
	@PostMapping("/editProduct")
	public String updateProduct(Model model,@Valid Product product) throws ProductException {
		Product prod = productService.findProductById(product.getProductId());
		prod.setProductName(product.getProductName());
		prod.setDescription(product.getDescription());
		prod.setPrice(product.getPrice());
		Product UpdatedProduct = productService.updateProduct(prod);
		
		model.addAttribute("product",UpdatedProduct);
		model.addAttribute("message", "Product Updated..");
		return "productPage";
	}
	
}
