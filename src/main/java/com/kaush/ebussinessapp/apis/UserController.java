package com.kaush.ebussinessapp.apis;

import java.util.List;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaush.ebussinessapp.dtos.LoginDataDTO;
import com.kaush.ebussinessapp.entities.Address;
import com.kaush.ebussinessapp.entities.Cart;
import com.kaush.ebussinessapp.entities.Product;
import com.kaush.ebussinessapp.entities.Role;
import com.kaush.ebussinessapp.entities.User;
import com.kaush.ebussinessapp.exceptions.UserNotFoundException;
import com.kaush.ebussinessapp.exceptions.UserRoleException;
import com.kaush.ebussinessapp.services.AddressService;
import com.kaush.ebussinessapp.services.CartService;
import com.kaush.ebussinessapp.services.RoleService;
import com.kaush.ebussinessapp.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/save")
	public User addUser(@Valid @RequestBody User user) throws UserNotFoundException, RoleNotFoundException {
		return userService.addUser(user);
	}
	
	@PostMapping("/login")
	public User userLogin( @RequestBody  LoginDataDTO logingDataDto) throws UserNotFoundException{
		return userService.findUserByLoginDetails(logingDataDto);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}
	
	@PostMapping("/addRoles")
	public Role addUserRoles(@RequestBody Role role) throws UserRoleException {
		return roleService.addUserRole(role);
	}
	
	@PostMapping("/addToCart")
	public Cart addProductToCart(@RequestBody Cart cart) {
		return cartService.addProductToCart(cart);
	}
	
	@DeleteMapping("/deleteItems/{Productid}")
	public Cart deleteItemsFromCart(@PathVariable Integer Productid, @RequestBody Cart cart) {
		return cartService.deleteProductFromCart(Productid, cart );
		
	}
	
	@PostMapping("/createAddress")
	public Address saveAddress(@RequestBody Address address) {
		return addressService.save(address);
	}
	


}
