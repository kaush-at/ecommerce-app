package com.kaush.ebussinessapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data	
@RequiredArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addresId;
	
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
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private User user;
	
	
}
