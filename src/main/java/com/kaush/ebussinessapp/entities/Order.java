package com.kaush.ebussinessapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Order {

	
	@Id
	@GeneratedValue
	private Integer orderId;
	
	@NonNull
	private String email;
	
	@NonNull
	private Date orderDate;
	
	@NonNull
	private String orderStatus;
	
	@NonNull
	private Double totalPrice;
	
	@NonNull
	@ManyToOne
	private User user;
	
	@NonNull
	@OneToMany(mappedBy = "productId")
	private List<Product> products;
	
	
	
}
