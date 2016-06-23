package com.glendoncheney.queues;

public class QueueOverFlowException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  
	private String message;
	
	public QueueOverFlowException() {
		message = "The Queue is full";
	}
	
	public QueueOverFlowException(String m) {
		message = m;
	}
	
	public String getMessage() {
		
		return message;
	}
}