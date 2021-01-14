package com.kaush.ebussinessapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaush.ebussinessapp.dtos.LoginDataDTO;
import com.kaush.ebussinessapp.entities.Cart;
import com.kaush.ebussinessapp.entities.Product;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.UserNotFoundException;
import com.kaush.ebussinessapp.services.ProductService;
import com.kaush.ebussinessapp.services.UserService;


@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("loginData",new LoginDataDTO());
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginData",new LoginDataDTO());
		return "login";
	}
	
	@RequestMapping("/loginUser")
	public String userLogin(Model model, LoginDataDTO loginDTO) {

		try {
			User foundUser = userService.findUserByLoginDetails(loginDTO);
			if(foundUser!=null) {
				if(foundUser.getRole().getRoleName().equals("Customer")){
					model.addAttribute("cart", new Cart());
					model.addAttribute("productList", productService.findAllProducts());
					model.addAttribute("user", foundUser);
					return "showProducts";
				}
				if(foundUser.getRole().getRoleName().equals("Admin")) {
					model.addAttribute("product", new Product());
					model.addAttribute("user", foundUser);
					model.addAttribute("productList", productService.findAllProducts());
					return "addProduct";
				}
			}
			return "login";
		}catch(UserNotFoundException ex) {
			model.addAttribute("message", "Invalid Credentials please check your user name and password");
			model.addAttribute("loginData",new LoginDataDTO());
			return "login";
		}
	
	}

	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("formData",new User());
		return "register";
	}
	
	@RequestMapping("/saveUser")
	public String registerUser(Model model, @Valid User user) {

		try {
			userService.addUser(user);
			model.addAttribute("productList", productService.findAllProducts());
			model.addAttribute("cart", new Cart());
			return "showProducts";
		}catch(Exception ex){
			model.addAttribute("message", ex.getMessage());
			model.addAttribute("formData",new User());
			return "register";
		}

	}
	
	

}
