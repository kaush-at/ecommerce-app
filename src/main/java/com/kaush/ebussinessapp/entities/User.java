package com.kaush.ebussinessapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	private String password;
	
	@NonNull
	private String username;
	
	@OneToMany
	private UserRole role;
	
	@NonNull
	@OneToOne
	private Address address;
	
	@NonNull
	@OneToOne
	private Cart shoppingCart;
	
	@OneToMany
	private Order order;
	
	
	

}
