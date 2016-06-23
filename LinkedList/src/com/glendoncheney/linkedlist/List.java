package com.glendoncheney.linkedlist;

public interface List<E> {

	/**
	 * Add an element at the front of the DLL
	 * @param element The element to add
	 */
	public void addFirst(E element);

	
	/**
	 * Add an element at the rear of the DLL
	 * @param element The element to add
	 */
	public void addLast(E element);
	
	
	/**
	 * Method to remove the last element of the Linked List
	 * @return The last element stored in the List
	 * @throws EmptyListException
	 */
	public E removeLast() throws EmptyListException;		

	
	/**
	 * Method to remove the first element of the DLL
	 * @return The first element stored in the List
	 * @throws EmptyListException
	 */
	public E removeFirst() throws EmptyListException;
	
	
	/**
	 * Returns wether or not the List is currently empty
	 * @return True if the list is empty, false otherwise 
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the current number of elements stored
	 * in the list
	 * @return the current size of the list
	 */
	public int size();
	
	/**
	 * Method to get the first element in the List
	 * @return The first element in the List
	 */
	public E getFirst();

	/**
	 * Method to get the last element in the DLL
	 * @return The last element in the DLL
	 */
	public E getLast();
	
	/**
	 * Returns a type-safe array representation of the 
	 * elements in this list
	 * @return A type-safe array representation of this list
	 */
	public E[] toArray(E[] a);
}
