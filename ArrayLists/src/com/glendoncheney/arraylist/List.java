package com.glendoncheney.arraylist;

public interface List<E> {

	/**
	 * Checks if the List contains the element
	 * @param element The element to check for
	 * @return true if the List contains @element, false otherwise
	 */
	public abstract boolean contains(E element);

	/**
	 * Find and returns the index of a specified element in the List
	 * @param element The element to find
	 * @return The index of the element or -1 
	 */
	public abstract int indexOf(E element);

	/**
	 * Returns the element at the specified index
	 * @param index The index to look in for the element 
	 * @return The element at the specified index
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public abstract E get(int index);

	/**
	 * Adds an element to the list
	 * @param element The element to be added
	 */
	public abstract void add(E element);

	/**
	 * Removes the last added element
	 * @return The removed element
	 */
	public abstract E remove();

	/**
	 * Removes the element at the specified index
	 * @param index The index to remove the element from
	 * @throws ArrayIndexOutOfBoundsException
	 * @return The removed element 
	 */
	public abstract E remove(int index);

	/**
	 * Returns the size of the List
	 * @return The size of the list
	 */
	public abstract int size();

	/**
	 * Check wether or not the List is empty
	 * @return True is the list is empty, false otherwise
	 */
	public abstract boolean isEmpty();

	/**
	 * Converts the List into a standard array 
	 * @param a An array of type E to convert the list to
	 * @return The returned array
	 */
	public abstract E[] toArray(E[] a);

}