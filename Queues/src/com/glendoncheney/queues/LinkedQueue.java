package com.glendoncheney.queues; 

/**
 * The LinkedQueue class uses an 
 * linked list to implement a queue
 * @author glen
 *
 */

public class LinkedQueue<E> implements Queue<E> {
	//private inner class for linking Nodes
	private class Node {
		E value;
		Node next;
		
		Node(E val, Node n)	{
			value = val;
			next = n;
		}
	}
	
	private Node front; 		
	private Node rear;			
	private int size;
	

	/**
	 * Create an empty LinkedQueue
	 */
	public LinkedQueue() {
		size = 0;
		front = null; 
		rear = null;
	}
	
	/**
	 * The enqueue method adds an element to the queue
	 * @param s The element to be added to the queue
	 */
	@Override
	public void enqueue(E s) {
		if (rear != null){
			rear.next = new Node(s, null);
			rear = rear.next;
		}
		else {	//First element added
			rear = new Node(s, null);
			front = rear;
		}		
		size++;
	}
	
	/**
	 *The peek method returns the item at the 
	 *front of the queue. 
	 * @return The element at the front of the queue, or null
	 */
	@Override
	public E front() {
		if(isEmpty()){
			throw new EmptyQueueException();
		}
		
		return front.value;
	}
	
	/**
	 * The dequeue method removes and returns 
	 * the element at the front of the queue
	 * @return The element being removed, or null
	 */
	@Override
	public E dequeue() {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		}
		
		E value = front.value; //The value being dequeued
		front = front.next;
		if (front==null) {
			rear = null;
		}
		
		size--;
		return value;
	}
	
	/**
	 * The isEmpty method checks to see if
	 * this queue is Empty
	 * @return true if the queue is empty,
	 * false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return (size==0);
	}
	
	/**
	 * The toString method concatenates all strings
	 * in the queue to give a string representation 
	 * of the queue contents
	 * @return string representation of this queue
	 */
	@Override
	public String toString(){
		StringBuilder sBuilder = new StringBuilder();
		
		//Walk down the list and append all value
		Node temp = front;
		while (temp != null){
			sBuilder.append(temp.value + " ");
			temp = temp.next;
		}
		
		return sBuilder.toString();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isFull() {
		return false;
	}
	
}

