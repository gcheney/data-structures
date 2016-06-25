package com.glendoncheney.maps;

import java.util.HashSet;
import java.util.Set;


/**
 * A hash based implementation of a standard Map interface 
 * that utilizes a linear probing collision method
 * @author Glendon Cheney
 *
 * @param <K> The Key type
 * @param <V> The Value type
 */
public class HashMap<K, V> implements Map<K, V> {
	  private int size;
	  private final int DEFAULT_CAPACITY = 1000;
	  private EntrySet<K, V>[] entries;
	  
	  @SuppressWarnings("unchecked")
	  public HashMap() {
		  size = 0;
		  entries = new EntrySet[DEFAULT_CAPACITY];
	  }
	
	  @Override
	  public V get(K key) {
		  int position = hash(key);		  
		  while (entries[position] != null) {
			  if (entries[position].getKey().equals(key)) {
				  return entries[position].getValue();
			  }
			  position++;
		  }	 
		  
		  return null;
	  }
	  
	  @Override
	  public boolean containsKey(K key) {
		  return get(key) != null;
	  }
	  	  
	  @Override
	  public boolean containsValue(V value) {
		  for (EntrySet<K, V> entry : entries) {
			 if (entry != null) {
				 if (entry.getValue().equals(value)) {
					 return true;
				 }
			 }
		  }
		  
		  return false;
	  }
	  	
	  @Override
	  public int size() {
		  return size;
	  }
	  	  
	  @Override
	  public boolean isEmpty() {
		  return size == 0;
	  }
	  
	  @Override
	  public V put(K key, V value) {	
		    if (this.containsKey(key)) {
		    	int position = hash(key);	
		    	V previousValue = entries[position].getValue();
		    	entries[position].setValue(value);
		    	return previousValue;
		    }
		    
		    size++;
		    int position = hash(key);		
		    while (entries[position] != null) {
		    	position++;
		    }		    
		    entries[position] = new EntrySet<K, V>(key, value);	
		    
		    if (size == entries.length-1) {
		    	this.ensureCapacity();
		    }
		    return null;
	  }
	
	  @Override
	  public V remove(K key) {
		    if (this.containsKey(key)) {
		    	int position = hash(key);
		    	V value = entries[position].getValue();
		    	entries[position] = null;
		    	--size;
		    	
		    	if (size < entries.length/4) {
		    		this.condenseArray(entries.length);
		    	}
		    	
		    	return value;
		    }		    
		    
		    return null;
	  }
	  
	  @Override
	  public Set<K> keySet() {
		    Set<K> set = new HashSet<K>();
		    for (int i = 0; i < size; i++) {
		    	if (entries[i] != null) {
		    		set.add(entries[i].getKey());
		    	}
		    }		    
		    return set;
	  }
	  
	  @Override
	  public EntrySet<K, V>[] entrySet() {
		  @SuppressWarnings("unchecked")
		  EntrySet<K, V>[] currentEntries = new EntrySet[size];
		  int i = 0;
		  
		  for (EntrySet<K, V> entry : entries) {
			  if (entry != null) {
				  currentEntries[i] = entry;
				  i++;
			  }
		  }
		  
		  return currentEntries;
	  }
	  
	  /**
	   * Shrinks the underlying array to half its current size
	   * @param currentSize The current size of the array
	   */
	  private void condenseArray(int currentSize) {
		  @SuppressWarnings("unchecked")
		  EntrySet<K, V>[] tempEntries = new EntrySet[currentSize/2];
		  
		  for (EntrySet<K, V> entry : entries) {
			  if (entry != null) {
				  int position = hash(entry.getKey());		
				  while (tempEntries[position] != null) {
					  position++;
				  }			    
				  tempEntries[position] = entry;
			  }
		  }
		  
		  entries = tempEntries;
	  }
	  
	  /**
	   * Ensures that the entries array never reaches full capacity.
	   * Doubles the size of the underlying array
	   */
	  private void ensureCapacity() {
		  @SuppressWarnings("unchecked")
		  EntrySet<K, V>[] tempEntries = new EntrySet[entries.length*2];
		  
		  for (EntrySet<K, V> entry : entries) {
			  if (entry != null) {
				  int position = hash(entry.getKey());		
				  while (tempEntries[position] != null) {
					  position++;
				  }			    
				  tempEntries[position] = entry;
			  }
		  }
		  
		  entries = tempEntries;
	  }
	  
	  
	  /**
	 * Calculate the hash for an object being stored. Use the toString() 
	 * method to get a string from the Object and then add the ASCII values
	 * of the string
	 */
	 private int hash(Object key) {
		
		/* Start with a base, just so that it's not 0 for empty strings */
		int result = 4;
		
		String inputString = key.toString().toLowerCase();
		
		char [] characters = inputString.toCharArray();
		for (int i = 0; i < characters.length; i++)  {
			char currentChar = characters[i];
			
			if (currentChar == 'a' || currentChar == 'b' || currentChar == 'c' || 
				currentChar == 'e' || currentChar == 'e' || currentChar == 'f') {
					result += Integer.parseInt(""+currentChar, 16);
			}
		}		
		
		return (result % entries.length);
	}
} 
