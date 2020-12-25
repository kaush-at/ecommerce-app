package com.kaush.ebussinessapp.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue
	private Integer productId;
	
	@NonNull
	private String productName;
	
	@NonNull
	private String description;
	
	@NonNull
	private Double price;
	
	@NonNull
	private Integer quantity;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name="order_product", joinColumns = @JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="order_id"))
	private List<Order> orders;
	
	@Lob
    @Basic(fetch = FetchType.LAZY)
	@Column(name = "prod_image", columnDefinition="LONGBLOB")
	private byte[] productImage;

	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name="product_cart", joinColumns = @JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="cart_id"))
	private List<Cart> carts;
	
	
	
}
