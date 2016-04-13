package circulararray;

import java.util.Iterator;

public class CircularArray<E> implements Iterable<E> {
	private E[] items;
	private int head = 0;
	private final static int DEFAULT_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public CircularArray(int size) {
		items = (E[]) new Object[size];
	}
	
	public CircularArray() {
		this(DEFAULT_CAPACITY);
	}
	
	private int convert(int index) {
		if (index < 0) {
			index += items.length;
		}
		return (head + index) % items.length;
	}
	
	public E get(int i) {
		if (i < 0 || i >= items.length) {
			throw new IndexOutOfBoundsException("Index " 
						+ i + " is out of bounds");
		}
		return items[convert(i)];
	}
	
	public void set(int i, E item) {
		items[convert(i)] = item;
	}
	
	public Iterator<E> iterator() {
		return new CircularArrayIterator(this);
	}
	
	private class CircularArrayIterator implements Iterator<E> {
		private int currIndex = -1;
		private E[] items;
		
		public CircularArrayIterator(CircularArray<E> circularArray) {
			this.items = circularArray.items;
		}
		
		@Override
		public boolean hasNext() {
			return currIndex < this.items.length - 1;
		}
		
		@Override
		public E next() {
			currIndex++;
			E item = (E) this.items[convert(currIndex)];
			return item;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove is not supported by CircularArray");
		}
	}
}
