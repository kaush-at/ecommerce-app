package com.kaush.ebussinessapp.exceptions;

public class UserRoleException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserRoleException(String message) {
		super(message);
	}
	public UserRoleException(Integer id) {
	    super("Could not find User with  " + id);
	  }
	
	public UserRoleException() {
		super();
	}
}
