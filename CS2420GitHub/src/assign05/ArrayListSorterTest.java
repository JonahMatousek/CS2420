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
}
