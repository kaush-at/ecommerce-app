package com.kaush.ebussinessapp.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	
//	@ManyToOne
//	private Order order;
	
	@Lob
    @Basic(fetch = FetchType.LAZY)
	@Column(name = "prod_image", columnDefinition="LONGBLOB")
	private byte[] productImage;

	
	
	
}
