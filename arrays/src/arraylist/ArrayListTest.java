package arraylist;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void addingElementsAddsCorrectElement() {
		List<Integer> list = new ArrayList<Integer>(10);
		
        list.add(new Integer(2));
        list.add(new Integer(5));
        list.add(new Integer(1));
        list.add(new Integer(23));
        list.add(new Integer(14));
        
        assertEquals("List contains 2", true, list.contains(2));
        assertEquals("List contains 6", true, list.contains(23));
        assertEquals("Index of 14 is 4", 4, list.indexOf(14));
	}
	
	@Test
	public void gettingElementsReturnsCorrectElement() {
		List<Integer> list = new ArrayList<Integer>(10);
		
        list.add(new Integer(2));
        list.add(new Integer(5));
        list.add(new Integer(1));
        
        assertEquals("Get element 1 returns 5", Integer.valueOf(5), list.get(1));
        assertEquals("Get element 0 returns 2", Integer.valueOf(2), list.get(0));
	}

	@Test
	public void sizeMethodReturnsCorrectSize() {
		List<Integer> list = new ArrayList<Integer>(10);
		
        list.add(new Integer(2));
        list.add(new Integer(5));
        list.add(new Integer(1));
        
        assertEquals("List size is 3", 3, list.size());
        
        list.remove();
        assertEquals("List size is 2", 2, list.size());
        
        list.remove(0);
        list.remove();
        
        assertEquals("List size is 0", 0, list.size());
	}
	
	@Test
	public void emptyMethodReturnsEmpty() {
		List<Integer> list = new ArrayList<Integer>(10);
		
        assertEquals("List is empty", true, list.isEmpty());
        
        list.add(2);
        
        assertEquals("List is not empty", false, list.isEmpty());
	}
	
	@Test
	public void toArrayMethodCreatesArray() {
		List<Integer> list = new ArrayList<Integer>(10);
		
        list.add(new Integer(2));
        list.add(new Integer(5));
        list.add(new Integer(1));
        
        Integer [] listAsArray = new Integer[3];
        listAsArray = list.toArray(listAsArray);
        
        Integer [] standardArray = {2, 5, 1};
        
        assertEquals("Arrays are equal", true, Arrays.equals(listAsArray, standardArray));
	}
}
