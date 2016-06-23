package com.glendoncheney.queues;

/**
 * Defines a generic interface for all queues
 * @author glendon cheney
 *
 * @param <E>
 */
public interface Queue<E> {
	
	/**
	 * Returns the current size of the queue
	 * @return The current size of the queue
	 */
	public int size();
	
	/**
	 * Returns true if the queue contains no elements,
	 * or false otherwise
	 * @return True if the queue is empty, 
	 * false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Returns true if the queue has reached 
	 * its maximum capacity, or false otherwise
	 * @return True if the queue is empty, 
	 * false otherwise
	 */
	public boolean isFull();
	
	/**
	 * Inserts a new element at the end of the queue
	 * @param element The element to be inserted
	 */
	public void enqueue(E element);
	
	/**
	 * Removes an element from the front of the queue
	 * @return The element currently at the front of the queue
	 */
	public E dequeue();
	
	/**
	 * Returns but does NOT remove the element from the 
	 * front of the queue
	 * @return The element currently at the front of the queue
	 */
	public E front();
}
