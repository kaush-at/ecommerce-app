package com.kaush.ebussinessapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@NonNull
	@NotBlank(message = "User's name is mandatory")
	private String name;
	
	private Date dob;
	
	private Boolean isEnabled;
	
	@NonNull
	@NotBlank(message = "Email is mandatory")
	@Email
	private String email;
	
	@NonNull
	@NotBlank(message = "Password cannot be empty")
	private String password;
	
	@NonNull
	@Size(min = 2, max = 50, message="User name should be valid") 
	private String username;  
	
//	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
//	private Set<Role> roles;
	
//	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
//    @JoinColumn(name = "role_id", referencedColumnName = "role_id")}, uniqueConstraints = @UniqueConstraint(columnNames = {
//                        "user_id", "role_id" }))
//	private Set<Role> roles;
	
	@NonNull
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="role_id")
	private Role role;
	
	@NonNull
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToOne(mappedBy = "user", cascade =CascadeType.ALL)
	private Cart shoppingCart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade =CascadeType.MERGE)
	private List<Ordertbl> orders;
	

	
	

}
