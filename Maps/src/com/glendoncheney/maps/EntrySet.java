package com.glendoncheney.maps;

/**
 * An object that represents a set entry into a HashMap
 * @author glen
 *
 * @param <K> The generic Key type
 * @param <V> the generic Value type
 */
public class EntrySet<K, V> {
	  private final K key;
	  private V value;

	  /**
	   * Constructs a new MyEntrySet
	   * @param key The key for this set
	   * @param value The Value for this set
	   */
	  public EntrySet(K key, V value) {
	      this.key = key;
	      this.value = value;
	  }

	  /**
	   * Returns the key stored in this set
	   * @return The key stored in this set
	   */
	  public K getKey() {
		  return key;
	  }

	  /**
	   * Returns the value stored in this set
	   * @return The value stored in this set
	   */
	  public V getValue() {
		  return value;
	  }

	  /**
	   * Sets the value for this EntrySet
	   * @param value The value to be stored in this set
	   */
	  public void setValue(V value) {
		  this.value = value;
	  }
	  
	  @Override
	  public String toString() {
		  StringBuilder sb = new StringBuilder();
		  
		  sb.append("Key: ");
		  sb.append(this.key.toString());
		  sb.append("  ");
		  sb.append("Value: ");
		  sb.append(this.value.toString());
		  sb.append("   ");
		  
		  return sb.toString();
	  }
} 
