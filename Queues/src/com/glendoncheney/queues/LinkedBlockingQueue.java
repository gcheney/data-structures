package com.glendoncheney.queues;

class LinkedBlockingQueue<E> implements BlockingQueue<E> {

	  private static class Node<E> {
		  E item;
		  Node<E> next;
		  
		  public Node(E item) {
			  this.item = item;
			  next = null;
		  }
	  }
	  
	  
	  private Node<E> head;
	  private int maxSize = 10;	
	  private int currSize;

	  public LinkedBlockingQueue(int limit){	  
	    maxSize = limit;
	    currSize = 0;
	    head = null;
	  }


	  public synchronized void put(E item) throws InterruptedException {
		    if (item == null) {
		    	throw new NullPointerException("Null items cannot be inserted");
		    }
		    
		    while (currSize == maxSize) {
		      wait();
		    }
		    if (currSize == 0) {
		      notifyAll();
		    }
		    
		    //clear to be added
		    //if head is null
		    if (head == null) {
		    	head = new Node<E>(item);
		    }
		    else {
			    Node<E> current = head;
			    Node<E> prev = head;
			    
			    while (current != null) {
			    	prev = current;
			    	current = current.next;
			    }
			    
			    //Add item
			    prev.next =  new Node<E>(item);
		    }
		    
		    currSize++;
		    
		    System.out.println("Put " + item);
	  }


	  public synchronized E take() throws InterruptedException {
		    while (currSize == 0) {
		      wait();
		    }
		    if (currSize == maxSize) {
		      notifyAll();
		    }
		
		    E toTake = head.item;
		    head = head.next;
		    
		    --currSize;
		    
		    System.out.println("Took " + toTake);
		    
		    return toTake;
	  }	
	  
	  
	  
	  /*
	   * package queue;
//using arraylist
import java.util.LinkedList;
import java.util.List;

class LinkedBlockingQueue<E> implements BlockingQueue<E> {

	  private List<E> queue = new LinkedList<E>();
	  private int limit = 10;
	  private final int FRONT = 0;

	  public LinkedBlockingQueue(int limit){
		  
	    this.limit = limit;
	  }


	  public synchronized void put(E item) throws InterruptedException  
	  {
		    if(item == null) {
		    	throw new NullPointerException("Null items cannot be inserted");
		    }
		    
		    while(queue.size() == limit) {
		      wait();
		    }
		    if(queue.size() == 0) {
		      notifyAll();
		    }
		    
		    this.queue.add(item);
	  }


	  public synchronized E take() throws InterruptedException
	  {
		    while(queue.size() == 0) {
		      wait();
		    }
		    if(queue.size() == limit) {
		      notifyAll();
		    }
		
		    return this.queue.remove(FRONT);
	  }	
}
*/

}
