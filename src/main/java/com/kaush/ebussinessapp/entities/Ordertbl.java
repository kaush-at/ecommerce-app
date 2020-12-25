package com.kaush.ebussinessapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Ordertbl {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	@NonNull
	private String email;
	
	@NonNull
	private Date orderDate;
	
	@NonNull
	private String orderStatus;
	
	@NonNull
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	

	
	
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name="order_product", joinColumns = @JoinColumn(name="order_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
	@JsonIgnore
	private List<Product> products;
	
	
}
