package com.glendoncheney.queues;

/**
 * A Deque is a doubly ended queue, that allows 
 * insertion and deletion at both the ends.
 * This can be implemented by using a doubly 
 * linked list with all the operations in O(1). 
	Implementation can very easily be provided as 
	follows by creating two extra empty nodes header 
	and tailer pointing to each other at the start.
 	Manipulate the pointers for adding and deleting.
 * @author glendon cheney
 *
 */
public interface Deque<E> extends Queue<E> {
	
	/**
	 * Add an element to the front of the Deque
	 * @param element The element to add to the Deque
	 */
	public void enqueueFront(E element);
	
	/**Remove and return the rear element of the Deque
	 * 
	 * @return The element at the rear of the Deque
	 */
	public E dequeueRear();
	
	/**
	 * Returns but does not remove the rear element of the Deque
	 * @return The element at the rear of the Deque
	 */
	public E rear();
}
