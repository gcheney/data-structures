package com.glendoncheney.queues;

public interface BlockingQueue<E> {
	
		public abstract void put(E item) throws InterruptedException ; 

		public abstract E take() throws InterruptedException ;

}
