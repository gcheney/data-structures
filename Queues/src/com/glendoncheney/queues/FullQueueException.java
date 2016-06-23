package com.glendoncheney.queues;

public class FullQueueException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor that creates a new 
	 * FullQueueException with the default error
	 * message
	 */
	public FullQueueException() {
		super("The queue is full");
	}

	/**
	 * Constructs a new FullQueueException with 
	 * the user supplied error message
	 * @param message The exceptions error message
	 */
	public FullQueueException(String err) {
		super(err);
	}
}

