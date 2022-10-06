/**
 * 
 */
package assign05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author Jonah Matousek and Casey Parker
 *
 */
public class ArrayListSorterTest {

	@Test
	void testMergesort() {
		ArrayList<Integer> list = ArrayListSorter.generatePermuted(10);
		ArrayListSorter.mergesort(list);
		String correct = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]";
		assertEquals(correct, list.toString());
	}
	
	void testMergesortWithDuplicateVals() {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(6);
		list.add(3);
		list.add(1);
		list.add(3);
		list.add(2);
		ArrayListSorter.mergesort(list);
		String correct = "[1, 1, 2, 2, 2, 3, 3, 3, 3, 6]";
		assertEquals(correct, list.toString());
	}
}
