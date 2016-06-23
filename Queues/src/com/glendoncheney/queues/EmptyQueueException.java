package com.glendoncheney.queues;

public class EmptyQueueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor that creates a new 
	 * EmptyQueueException with the default error
	 * message
	 */
	public EmptyQueueException() {
		super("The queue is empty");
	}

	/**
	 * Constructs a new EmptyQueueException with 
	 * the user supplied error message
	 * @param message The exceptions error message
	 */
	public EmptyQueueException(String err) {
		super(err);
	}
}

