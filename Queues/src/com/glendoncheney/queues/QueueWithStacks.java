package com.glendoncheney.queues;

import java.util.Stack;

/**
 * This class demonstrates how to create 
 * a functioning queue using two stacks
 * @author glendon cheney
 *
 * @param <E>
 */
public class QueueWithStacks<E> {

    private Stack<E> inbox, outbox;
    
    /**
     * Initialize the two empty stacks
     */
    public QueueWithStacks() {   	
    	inbox = new Stack<E>(); 
    	outbox = new Stack<E>();
    }

    /**
     * Add the item to the inbox stack
     * @param item The item to be added
     */
    public void enqueue(E item) {
        inbox.push(item);
    }

    /**
     * If outbox is empty, move all items
     * from inbox to outbox
     * @return The top element of outbox,
     * which was the bottom element of inbox
     */
    public E dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {	            	
               outbox.push(inbox.pop());
            }
        }
        
        return outbox.pop();
    }
    
    /**
     * If inbox array is empty, 
     * @return
     */
    public boolean isEmpty() {
    	
    	if (inbox.isEmpty() && outbox.isEmpty()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    /**
     * Returns the size of the queue
     * @return The number of components in the queue
     */
    public int size() {  	
    	return (inbox.size() + outbox.size());
    }
    
    /**
     * Test Client
     */
    public static void main(String[] args) {
    	QueueWithStacks<Integer> queue = new QueueWithStacks<Integer>();
    	
    	int [] a = {1,3,2,4,6,5,7,9,8,10};
    	
    	for (Integer i : a) {
    		queue.enqueue(i);
    	}
    	
    	System.out.println(queue.dequeue());
    	System.out.println(queue.isEmpty() + " Size: " + queue.size());
    	
    	queue.enqueue(11);
    	
    	while (!queue.isEmpty()) {
    		System.out.println(queue.dequeue());
    	}
    	
    }

}

