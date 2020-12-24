package com.kaush.ebussinessapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data	
public class Cart {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NonNull
	private Date addedDate;
	
	@NonNull
	private String email;
	
	@NonNull
	private Double price;
	
	@NonNull
	private Integer quantity;
	
	@NonNull
	@OneToMany  // is it compulsory to put mappedBy and is it compulsory to have relationship to other table
	private List<Product> products;
	
	
	
	
}
