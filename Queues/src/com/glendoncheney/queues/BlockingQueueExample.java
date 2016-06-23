package com.glendoncheney.queues;

class Consumer implements Runnable {
	
    private BlockingQueue<String> queue = null;

    public Consumer(BlockingQueue<String> queue) {	    	
        this.queue = queue;
    }

    public void run() {
        try {
        	while (true) {
	            queue.take();
	            queue.take();
	            queue.take();
        	}
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}


class Producer implements Runnable {

    private BlockingQueue<String> queue = null;

    public Producer(BlockingQueue<String> queue) {
    	
        this.queue = queue;
    }

    public void run() {
        try {
        	while (true) {
	            queue.put("1");
	            Thread.sleep(1000);
	            
	            queue.put("2");
	            Thread.sleep(1000);
	            
	            queue.put("3");
        	}
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class BlockingQueueExample {
	
	public static void main(String[] args) throws Exception {

		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
		//uncommment to demo LinkedBlockingQueue
		//BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(consumer);
        
        pThread.start();
        cThread.start();

        Thread.sleep(4000);
    }
		
}