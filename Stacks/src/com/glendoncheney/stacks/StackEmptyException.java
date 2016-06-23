package com.glendoncheney.stacks;

public class StackEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	
	public StackEmptyException() {
		message = "The Stack is Empty";
	}
	
	public StackEmptyException(String m) {
		message = m;
	}
	
	public String getMessage() {
		return message;
	}
}
