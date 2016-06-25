package com.glendoncheney.maps;

import java.util.Set;

/**
 * A generic Map interface
 * @author glen
 *
 * @param <K> The Key type
 * @param <V> The Value type
 */
public interface Map<K, V> {
	
	/**
	 * Gets and returns, but does not remove, the value associated
	 * with the key
	 * @param key The associated Key
	 * @return The Value associate with the given Key
	 */
	  public V get(K key);	  
	  
	  /**
	   * Returns true if the given key is contained in 
	   * the Map, false otherwise
	   * @param key The key to check
	   * @return true if the given key is contained in 
	   * the Map, false otherwise
	   */	  
	  public boolean containsKey(K key);
	  
	  /**
	   * Returns true if the given value is contained in 
	   * the Map, false otherwise
	   * @param value The value to check
	   * @return true if the given value is contained in 
	   * the Map, false otherwise
	   */	  
	  public boolean containsValue(V value);
	  
	  /**
	   * Returns the current size, or number of entries,
	   * stored in the Map
	   * @return The current size of the map
	   */
	  public int size();
	  	  
	  /**
	   * returns true if the Map is currently empty,
	   * false otherwise
	   * @return True if the map is empty, false otherwise
	   */
	  public boolean isEmpty();
	  
	  /**
	   * Creates a new Map Entry for this key and value pair, 
	   * or if the key already exist in the map, replaces
	   * its current value with the provided one
	   * @param key The key to place in the map
	   * @param value The associated value
	   * @return The previous Value associated with the Key,
	   * or null if no such value exist
	   */
	  public V put(K key, V value);
	
	  /**
	   * Removes the key and associated value from the Map
	   * @param key The key to remove
	   * @return The value associated with the given Key
	   */
	  public V remove(K key);
	  	  
	  /**
	   * Returns a Set<K> of all the keys contained
	   * within the Map
	   * @return A Set<K>, of all the keys contained
	   * within the Map
	   */
	  public Set<K> keySet();
	  
	  /**
	   * Returns an array of the EntrySet<K,V> objects 
	   * from the Map
	   * @return
	   */
	  public EntrySet<K, V>[] entrySet();
}
