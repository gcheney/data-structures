package com.glendoncheney.stacks;

import java.util.*;

/**
 * Array implementation of a Stack
 * @author glen
 */

public class ArrayStack<E> implements Stack<E>{
	private E [] stack; 
	private int top; 
	private int size;
	private final static int DEFAULT_CAP = 10;
	
	/**
	 * Default constructor, creates ArrayStack with default
	 * capacity
	 */
	public ArrayStack() {
		this(DEFAULT_CAP);
	}
	
	/**
	 * Constructor
	 * @param capacity The capacity of the stack
	 */	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity){
		stack = (E[])new Object[capacity];
		top =  -1;
		size = 0;
	}
	
	/**
	 * The isEmpty method checks if the stack is empty
	 * @return returns true if the stack is empty, false otherwise 
	 */
	
	public boolean isEmpty(){
		return (top == -1);

	}
	
	/**
	 * The isFull method checks to see if the stack
	 * is full
	 * @return true if the stack is full, false otherwise
	 */
	
	public boolean isFull() {
		return (top == stack.length - 1);
	}
	
	/**
	 * The push method pushes a value onto the stack
	 * @param x The value to push on the stack
	 * @return The value that was pushed onto the stack
	 * @exception StackOverflowException When the
	 * stack is full
	 */
	
	public E push(E element) {
		if (top==stack.length) {
			throw new StackOverflowError();
		}
		else {
			top++;
			size++;
			stack[top] = element;
			return element;
		}
	}
	
	/**
	 * The pop value removes the top element from the stack
	 * @return The value popped
	 * @exception EmptyStackException when the stack
	 * is empty
	 */
	
	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			E popValue = stack[top];
			top--;
			size--;
			return popValue;
		}
	}
	
	/**
	 * The peek method returns the value at the top of the stack
	 * @return value at the top of the stack
	 * @exception EmptyStackException when the stack is empty
	 */
	
	public E peek(){
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		return stack[top];
	}

	@Override
	public int size() {
		return size;
	}
	
}

