package com.glendoncheney.linkedlist;

public class OutOfBoundsException  extends RuntimeException {
  	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	/**
	 * Default constructor that creates a new 
	 * OutOfBoundsException with the default error
	 * message
	 */
	public OutOfBoundsException() {
		message = "That element is out of bounds";
	}

	/**
	 * Constructs a new OutOfBoundsException with 
	 * the user supplied error message
	 * @param message The exceptions error message
	 */
	public OutOfBoundsException (String message) {
    	this.message = message;
  	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
