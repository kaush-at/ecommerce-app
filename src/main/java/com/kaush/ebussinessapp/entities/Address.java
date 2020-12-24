package com.kaush.ebussinessapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data	
public class Address {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NonNull
	private String streetAddress;
	
	private String suit;
	private String floor;
	
	@NonNull
	private String city;
	
	@NonNull
	private String state;
	
	@NonNull
	private Integer zipCode;
	
	@NonNull
	private String country;
	
	@NonNull
	@OneToOne
	private User userId;
	
	
}
