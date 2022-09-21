package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class AnagramCheckerTest {

	@Test
	void testSortSimple() {
		String test = "bca";
		assertEquals("abc",AnagramChecker.sort(test));
	}
	
	@Test 
	void testInsertionSort(){
		String[] test = new String[] {"rat","apple","tar"};
		String[] correct = new String[] {"rat","tar","apple"};
		AnagramChecker.insertionSort(test, new AnagramComparator());
		//System.out.println(Arrays.toString(test));
		assertTrue(Arrays.equals(test, correct));
	}
	
	@Test
	void testAreAnagrams() {
		String test1 = "rat";
		String test2 = "tar";
		String test3 = "art";
		String test4 = "bruh";
		assertTrue(AnagramChecker.areAnagrams(test1, test2));
		assertTrue(AnagramChecker.areAnagrams(test1, test3));
		assertTrue(AnagramChecker.areAnagrams(test2, test3));
		assertFalse(AnagramChecker.areAnagrams(test2, test4));
	}
	
	@Test
	void testGetLargestAnagramGroup() {
		String[] test = new String[] {"enlist","glare","listen","silent","large"};
		String[] correct = new String[] {"enlist","listen","silent"};		
		//System.out.println(Arrays.toString(correct));
		//System.out.println(Arrays.toString(AnagramChecker.getLargestAnagramGroup(test)));
		assertTrue(Arrays.equals(AnagramChecker.getLargestAnagramGroup(test), correct));
		
	}

	

}
