package com.glendoncheney.maps;

import java.util.Iterator;
import java.util.Set;


/**
 * HashMap test client
 * 
 * @author Glendon Cheney
 */
public class MapTest {

	public static void main(String [] args) {
		testHashMap();
	}

	public static void testHashMap() {
		// Standard Map
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Lars", 1);
	  	map.put("Lars", 2);
	    map.put("Lars", 1);
	    System.out.println(map.get("Lars"));
		
	    for (int i = 0; i < 100; i++) {
	      map.put(String.valueOf(i), i);
	    }
	
	    System.out.println(map.size());	
	    System.out.println(map.get("51"));
	    
	    Set<String> keySet = map.keySet();	
	    Iterator<String> it = keySet.iterator();		
	    System.out.println("Keys: ");
	    while (it.hasNext()) {
		    System.out.print(it.next() + " ");
	    }
	    
	    System.out.println("key-value pais: ");
	    for (EntrySet<String, Integer> entrySet : map.entrySet()) {
	    	System.out.println(entrySet);
	    }
	}
}