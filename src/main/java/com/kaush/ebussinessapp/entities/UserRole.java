package com.kaush.ebussinessapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class UserRole {

	@Id
	@GeneratedValue
	private Integer roleId;
	
	@NonNull
	private String userRole;;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	
}
