package com.kaush.ebussinessapp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
//@Table(uniqueConstraints= @UniqueConstraint(columnNames={"role_id", "role_name"}))
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private Integer roleId;
	
	@NonNull
	@Column(name="role_name")
	private String roleName;

//	@ManyToMany(mappedBy = "roles", cascade =CascadeType.MERGE)
//	@JsonIgnore
//	private Set<User> users;
//	
//	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="role_id"), inverseJoinColumns = @JoinColumn(name="user_id"))
//	private List<User> users;
	
	
//	@JoinTable(name = "prod_colour", joinColumns = {
//	        @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")}, inverseJoinColumns = {
//	        @JoinColumn(name = "colour_id", referencedColumnName = "colour_id")}, uniqueConstraints = @UniqueConstraint(columnNames = {
//	                            "colour_id", "prod_id" }))
	
	
	@NonNull
	@JsonBackReference
	@OneToMany(mappedBy = "role")
	private List<User> user;
	
}
