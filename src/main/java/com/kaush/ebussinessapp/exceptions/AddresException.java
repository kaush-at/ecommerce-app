package com.kaush.ebussinessapp.exceptions;

public class AddresException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AddresException(String message) {
		super(message);
	}
	public AddresException(Integer id) {
	    super("Could not find Address with  " + id);
	  }
	
	public AddresException() {
		super();
	}
}
