package com.glendoncheney.arraylist;

import java.util.Arrays;

/**
 * This class implements a generic 
 * @author glendon cheney
 *
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
 
    private E[] elements;
    private int size = 0;
    private final static int DEFAULT_CAPACITY = 10;
    
    /**
     * Default constructor which sets the capacity of the initial array to 10
     */
    public ArrayList() {
    	this(DEFAULT_CAPACITY);
    }
     
    /**
     * Constructor which sets the initial size of the array to @size param
     * @param size The initial size of the array
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int size) {   	
        elements = (E[]) new Object[size];
    }
	
	@Override
	public boolean contains(E element) {
		if (this.isEmpty()) {
			return false;
		} 
		
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) {
				return true;
			}
		}	
		
		return false;
	}
	
	@Override
	public int indexOf(E element) {
		if (!this.isEmpty()) {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(element)) {
					return i;
				}
			}	
		}		
		
		return -1;
	}
     
    @Override
	public E get(int index) {    	
        if (index > size) {
        	throw new ArrayIndexOutOfBoundsException();
        }    
        
        return elements[index];
    }
     
    @Override
	public void add(E element) {    	
        if (elements.length - size <= 5) {
            increaseListSize();
        }  
        
        elements[size++] = element;
    }
    
    @Override
	public E remove() {    	
    	return this.remove(0);
    }
     
    @Override
	public E remove(int index) {   	
        if (index > size) {       	
        	throw new ArrayIndexOutOfBoundsException();
        } 
        
        E element = elements[index];
        elements[index] = null;
        int temp = index;
        
        while (temp < size) {            	
            elements[temp] = elements[temp+1];
            elements[++temp] = null;
        }
        
        size--;
        return element;
    }
     
    @Override
	public int size() {   	
        return size;
    }
    
    @Override
	public boolean isEmpty() {
    	return (size == 0);
    }
    
    @Override
	public E[] toArray(E[] a) {
    	if (a.length < size) {
    		@SuppressWarnings("unchecked")
			E[] result = (E[]) Arrays.copyOf(elements, size, a.getClass());
    		return result;
    	}
    	
    	System.arraycopy(elements, 0, a, 0, size);
    	if (a.length > size) {
    		a[size] = null;
    	}
    	return a;
    }
     
    private void increaseListSize() {
        elements = Arrays.copyOf(elements, elements.length * 2);
        System.out.println("\nNew length: " + elements.length);
    }
    
}