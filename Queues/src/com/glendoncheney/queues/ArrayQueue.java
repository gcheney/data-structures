package com.glendoncheney.queues;

import java.util.Arrays;

/**
 * This class implements the Queue<E> interface
 * using an array 
 * @author glendon cheney
 *
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
	private int capacity;				
	private final static int DEFAULT_CAPACITY = 10;	
	private int size;				
	private int front;					
	private int rear; 					
	private E queue[]; 					

	/**
	 */
	public ArrayQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor to create an array queue with a user defined size
	 * @param capacity The initial capacity of the queue
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity){
		front = 0;
		rear = 0;
		size = 0;
		this.capacity = capacity;
		queue =  (E[]) new Object[this.capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	@Override
	public boolean isFull() {
		return (size == capacity);
	}

	@Override
	public void enqueue(E element) {
		if (this.isFull()) {
			throw new FullQueueException("Cannot enqueue, "
					+ "ArrayQueue is full");
		}
		
		//If not full, add the element
		queue[rear] = element;
		size++;
		rear = (rear + 1) % capacity;		
	}

	@Override
	public E dequeue() {
		if (this.isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue, "
					+ "ArrayQueue is empty");
		}
		
		E element = queue[front];
		queue[front] = null;
		size--;
		front = (front+1) % capacity;
		return element;
	}

	@Override
	public E front() {
		return queue[front];
	}
	
	/**
	 * Prints out the string representation of the ArrayQueue
	 * @return String representation of the queue
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("<ArrayQueue[");
		
		for (int i = front; i < capacity; i++) {
			if (queue[i] != null) {
				sb.append(queue[i].toString() +",");
			}
		}
		
		if (front == rear) {
			for (int i = 0; i < rear; i++) {
				if (queue[i] != null) {
					sb.append(queue[i].toString() +",");
				}
			}
		}
							
		if (sb.charAt(sb.length()-1) == '[') {
			return sb.append("]>").toString();
		} else {
			return sb.substring(0, sb.length()-1) + "]>";
		}
	}
	
	
	/**
	 * Double the capacity of the array and retain the original elements
	 */
	public void doubleCapacity() {
		capacity = 2 * capacity; //Double the capacity
		queue = Arrays.copyOf(queue, capacity);
	}

}

