package com.glendoncheney.queues;

public class DoubleEndedQueueTest {

	public static void main(String[] args) {
		Deque<String> queue = new DoubleEndedQueue<String>();
		
		//add 4 names
		String [ ] names = 
			{"Alfonso", "bob", "carol", "Deborah"};
		System.out.println("Adding names to queue");
		
		for(String s : names){
			queue.enqueue(s);
			System.out.println(s + " was added");
		}
		
		System.out.println("State of the queue is \n" + queue);
		
		//Remove two names
		System.out.println("Removing two names..");
		queue.dequeue(); 
		queue.dequeueRear();
		System.out.println("State of the queue is \n" + queue);
		
		//Add another name
		System.out.println("Adding new name..");
		queue.enqueueFront("Elaine");
		System.out.println("State of the queue is \n" + queue);
		System.out.println("The first person in the queue is " + queue.front());
		System.out.println("The last person in the queue is " + queue.rear());
	}

}
