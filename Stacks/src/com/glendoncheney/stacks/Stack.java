package com.glendoncheney.stacks;

import java.util.EmptyStackException;

public interface Stack<E> {
	
	/**
	 * The isEmpty method checks if the stack is empty
	 * @return returns true if the stack is empty, false otherwise 
	 */	
	public boolean isEmpty();
	
	/**
	 * The isFull method checks to see if the stack
	 * is full
	 * @return true if the stack is full, false otherwise
	 */	
	public boolean isFull();
	
	/**
	 * The push method pushes a value on to the stack
	 * @param element The value to push on the stack
	 * @return The value that was pushed onto the stack
	 * @exception StackOverflowException When the
	 * stack is full
	 */	
	public E push(E element);
	
	/**
	 * The pop value removes the top element from the stack
	 * @return The value popped
	 * @exception EmptyStackException when the stack
	 * is empty
	 */	
	public E pop();
	
	/**
	 * The peek method returns the value at the top of the stack
	 * @return value at the top of the stack
	 * @exception EmptyStackException when the stack is empty
	 */	
	public E peek();
	
	/**
	 *  Returns the current size of the Stack
	 * @return The current size of the stack
	 */
	public int size();

}
