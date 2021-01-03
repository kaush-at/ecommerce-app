package com.kaush.ebussinessapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaush.ebussinessapp.entities.Product;
import com.kaush.ebussinessapp.services.ProductService;

@Controller
public class ProdController {

	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/addProduct")
	public String addProductPage(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}
	
	@RequestMapping("/saveProduct")
	public String addProduct(Model model, @Valid Product product, Errors errors) {
		if(errors.hasErrors()) {
			return "/register";
		}
		productService.addProduct(product);
		return "redirect:/addProduct";
	}
	
	@RequestMapping("/showAllProducts")
	public String showAllProducts(Model model) {
		model.addAttribute("products", productService.findAllProducts());
		return "showProducts";
	}
}
