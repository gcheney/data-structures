package com.glendoncheney.stacks;

public class LinkedStack<E> implements Stack<E> {
	
	/**
	 * The Node class is used to implement the linked list
	 */	
	private class Node {
		E value;
		Node next;
		
		//Node constructor
		Node(E val, Node n){
			value = val;
			next = n;
		}
	}
	
	private Node top; //top of the LinkedStack
	private int size; //size of the LinkedStack
	
	public LinkedStack() {
		top = null; 
		size = 0;
	}
	
	@Override
	public boolean isEmpty(){
		return top == null;
	}
	
	@Override
	public E push(E element){
		top = new Node(element, top);
		size++;
		return element;
	}
	
	@Override
	public E pop() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException();
		}
		else {
			E topValue = top.value;
			top = top.next;
			size--;
			return topValue;
		}
	}
	
	@Override
	public E peek() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException();
		}
		else {
			return top.value;
		}
	}
	
	/**
	 * The toString method returns a string 
	 * representation of the contents of the stack.
	 * @return the string of the stacks contents
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node tempNode = top;
		
		while (tempNode != null) {
			sb.append(tempNode.value);
			tempNode = tempNode.next;
			
			if (tempNode != null) {
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}

	@Override
	public boolean isFull() {
		// LinkedStack does not need to worry about being full
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}
	
}
