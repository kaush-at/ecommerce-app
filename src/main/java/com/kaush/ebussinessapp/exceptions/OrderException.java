package com.kaush.ebussinessapp.exceptions;

public class OrderException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public OrderException(String message) {
		super(message);
	}
	public OrderException(Integer id) {
	    super("Could not find Order with  " + id);
	  }
	
	public OrderException() {
		super();
	}

}
