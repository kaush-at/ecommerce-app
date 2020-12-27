package com.kaush.ebussinessapp.exceptions;

public class UserNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String message) {
		super(message);
	}
	public UserNotFoundException(Integer id) {
	    super("Could not find User with  " + id);
	  }
	
	public UserNotFoundException() {
		super();
	}
}
