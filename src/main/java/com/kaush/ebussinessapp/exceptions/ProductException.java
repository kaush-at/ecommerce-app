package com.kaush.ebussinessapp.exceptions;

public class ProductException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ProductException(String message) {
		super(message);
	}
	public ProductException(Integer id) {
	    super("Could not find Product with  " + id);
	  }
	
	public ProductException() {
		super();
	}

}
