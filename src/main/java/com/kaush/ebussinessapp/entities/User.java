package com.kaush.ebussinessapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue
	private Integer userId;
	
	@NonNull
	private String name;
	
	@NonNull
	private Date dob;
	
	private Boolean isEnabled;
	
	@NonNull
	@NotBlank(message = "Email is mandatory")
	@Email
	private String email;
	
	@NonNull
	@NotBlank(message = "Password cannot be empty")
	private String password;
	
	@NonNull
	@Size(min = 2, max = 50, message="User name should be valid") 
	private String username;
	
	@OneToMany(mappedBy = "user")
	private List<UserRole> roles;
	
	@NonNull
	@OneToOne
	private Address address;
	
	@NonNull
	@OneToOne
	private Cart shoppingCart;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
	
	
	

}
