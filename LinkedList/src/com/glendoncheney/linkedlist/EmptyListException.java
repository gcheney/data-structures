package com.glendoncheney.linkedlist;

public class EmptyListException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	/**
	 * Default constructor that creates a new 
	 * EmptyListException with the default error
	 * message
	 */
	public EmptyListException() {
		message = "The list is empty";
	}

	/**
	 * Constructs a new EmptyListException with 
	 * the user supplied error message
	 * @param message The exceptions error message
	 */
	public EmptyListException(String message) {
    	this.message = message;
  	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
