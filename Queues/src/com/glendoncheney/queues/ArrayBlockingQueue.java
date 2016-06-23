package com.glendoncheney.queues;

/**
 * This class implements a blocking queue using an array
 * @author glendon cheney
 *
 * @param <E>
 */
public class ArrayBlockingQueue<E extends Object> implements BlockingQueue<E> {
	  
	  private Object[] queueArray;
	  private int maxSize = 10;	
	  private int currIndex;

	  public ArrayBlockingQueue(int limit) {		  
		    maxSize = limit;
		    queueArray = new Object[maxSize];
		    currIndex = -1;
	  }


	  public synchronized void put(E item) throws InterruptedException  
	  {
		    if (item == null) {
		    	throw new NullPointerException("Null items cannot be inserted");
		    }
		    
		    while (currIndex == (maxSize - 1)) {
		      wait();
		    }
		    if (currIndex == -1) {
		      notifyAll();
		    }
		    
		    ++currIndex;	
		    
		    queueArray[currIndex] = item;	
		    
		    System.out.println("Put " + item);
	  }


	  @SuppressWarnings("unchecked")
	  public synchronized E take() throws InterruptedException {
		    while (currIndex == -1) {
		      wait();
		    }
		    if (currIndex == (maxSize - 1)) {
		      notifyAll();
		    }
		
		    E toTake = (E) queueArray[0];
		    
		    for (int i = 0; i < currIndex; i++) {
		    	queueArray[i] = queueArray[i + 1];
		    }
		    
		    --currIndex;
		    System.out.println("Took " + toTake);
		    
		    return toTake;
	  }	
}