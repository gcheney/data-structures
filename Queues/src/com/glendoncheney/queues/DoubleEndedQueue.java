package com.glendoncheney.queues;

public class DoubleEndedQueue<E> implements Deque<E> {
	
	private class Node {
		E value;
		Node next;
		Node prev;
		
		Node() {
			this(null);
		}
		
		Node(E value) {
			this.value = value;
			next = null;
			prev = null;
		}
	}

	//Dummy nodes
	private Node pred = new Node();
	private Node post = new Node();
	private int size;
	
	public DoubleEndedQueue() {
		pred.next = post;
		post.prev = pred;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void enqueue(E element) {
		Node toInsert = new Node(element);
		size++;
		toInsert.next = post;
		toInsert.prev = post.prev;
		post.prev.next = toInsert;
		post.prev = toInsert;
	}

	@Override
	public E dequeue() {
		if (this.isEmpty()){
			throw new EmptyQueueException();
		}
		
		Node toRemove = pred.next;
		pred.next = toRemove.next;
		toRemove.next.prev = pred;
		E element = toRemove.value;		
		--size;
		toRemove = null;
		return element;
	}

	@Override
	public E front() {
		if (this.isEmpty()){
			throw new EmptyQueueException();
		}
		
		return pred.next.value;
	}

	@Override
	public void enqueueFront(E element) {
		Node toInsert = new Node(element);
		size++;
		
		toInsert.prev = pred;
		toInsert.next = pred.next;
		pred.next.prev = toInsert;
		pred.next = toInsert;
	}

	@Override
	public E dequeueRear() {
		if(isEmpty()){
			throw new EmptyQueueException();
		}
		
		Node toRemove = post.prev;
		post.prev = toRemove.prev;
		toRemove.prev.next = post;
		E element = toRemove.value;	
		--size;
		toRemove = null;
		return element;
	}

	@Override
	public E rear() {
		if(isEmpty()){
			throw new EmptyQueueException();
		}
		
		return post.prev.value;
	}
	
	@Override
	public String toString() {
		if (this.isEmpty()) {
			return "Queue is empty";
		}
		
		StringBuilder sb = new StringBuilder("[");
		for (Node curr = pred.next; curr != post; curr = curr.next) {
			sb.append(curr.value + ", ");
		}
		
		sb.delete(sb.length()-2, sb.length()); //clean up
		sb.append("]");
		return sb.toString();
	}

}
