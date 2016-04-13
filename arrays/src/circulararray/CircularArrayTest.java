package circulararray;

import static org.junit.Assert.*;
import org.junit.Test;

public class CircularArrayTest {

	@Test
	public void out() {
	    CircularArray<Integer> circArray = new CircularArray<Integer>();
	    circArray.set(0, 1);
	    circArray.set(1, 2);
	    circArray.set(2, 3);
	    circArray.set(3, 4);
	    
	    for (Integer i : circArray) {
	    	System.out.println(i);
	    }
	    
	    for (int i = 0; i < 4; ++i) {
	    	assertEquals(Integer.valueOf(i + 1), circArray.get(i));
	    }
	}

}
