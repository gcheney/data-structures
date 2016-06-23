package com.glendoncheney.queues;

public class QueueUnderFlowException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;    
	private String message;
	
	public QueueUnderFlowException() {
		message = "The Queue is full";
	}
	
	public QueueUnderFlowException(String m) {
		message = m;
	}
	
	public String getMessage() {		
		return message;
	}
}