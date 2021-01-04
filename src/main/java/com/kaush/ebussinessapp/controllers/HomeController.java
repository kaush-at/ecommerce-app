package com.kaush.ebussinessapp.controllers;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaush.ebussinessapp.dtos.LoginDataDTO;
import com.kaush.ebussinessapp.entities.Cart;
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
	public String home() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginData",new LoginDataDTO());
		return "login";
	}
	
	@RequestMapping("/loginUser")
	public String userLogin(Model model, LoginDataDTO loginDTO, Errors errors) throws UserNotFoundException {
		if(errors.hasErrors()) {
			return "/login";
		}
		userService.findUserByLoginDetails(loginDTO);
		model.addAttribute("productList", productService.findAllProducts());
		model.addAttribute("cart", new Cart());
		return "showProducts";
	}

	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("formData",new User());
		return "register";
	}
	
	@RequestMapping("/saveUser")
	public String registerUser(Model model, @Valid User user, Errors errors) throws RoleNotFoundException, UserNotFoundException {
		if(errors.hasErrors()) {
			return "/register";
		}
		userService.addUser(user);
		model.addAttribute("productList", productService.findAllProducts());
		model.addAttribute("cart", new Cart());
		return "showProducts";
	}
	
	

}
