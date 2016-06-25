package com.glendoncheney.maps;

import java.util.Arrays;

/**
 * The StackMap class implements a Stack 
 * @author Glendon Cheney
 *
 * @param <K> The Key type
 * @param <V> The Value type
 */
public class StackMap<K, V> implements Stack<EntrySet<K, V>>{
	private int size = 0;
	private int top = -1;
	private final int DEFAULT_CAPACITY = 20;
	@SuppressWarnings("unchecked")
	private EntrySet<K, V> [] stack = new EntrySet[DEFAULT_CAPACITY]; 

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public EntrySet<K, V> peek() {
		if (this.isEmpty()) {
			return null;
		}
		
		return stack[top];
	}
	
	@Override
	public EntrySet<K, V> pop() {
		if (this.isEmpty()) {
			return null;
		}		
		EntrySet<K, V> set = stack[top--];
		size--;
		return set;
	}
	
	public void push(K key, V value) {
		EntrySet<K, V> set = new EntrySet<K, V>(key, value);
		stack[++top] = set;
		ensureCapacity();
		size++;		
	}
	
	@Override
	public EntrySet<K, V> push(EntrySet<K, V> set) {
		stack[++top] = set;
		ensureCapacity();
		size++;	
		return set;
	}
	
	private void ensureCapacity() {
	    if (this.isFull()) {
		      int newSize = stack.length * 2;
		      stack = Arrays.copyOf(stack, newSize);
	    }
	}

	@Override
	public boolean isFull() {
		return size == stack.length-1;
	}
	
}
