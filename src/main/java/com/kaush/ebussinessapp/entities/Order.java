package com.kaush.ebussinessapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name="order_product", joinColumns = @JoinColumn(name="order_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> products;
	
	
}
