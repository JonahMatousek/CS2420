package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class AnagramCheckerTest {

	@Test
	void testSortSimple() {
		String test = "bca";
		assertEquals("abc",AnagramChecker.sort(test));
	}
	
	@Test
	void testSortAlphabetRandom1() {
		String test = "QWERTYUIOPASDFGHJKLZXCVBNM";
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",AnagramChecker.sort(test));
	}
	//TEST INSERTION SORT
	
	@Test 
	void testInsertionSort(){
		String[] test = new String[] {"rat","apple","tar","acme","random","came","brautworst", "mace","actors","costal","costar"};
		String[] correct = new String[] {"rat","tar","acme","came","mace","apple","random"};
		AnagramChecker.insertionSort(test, new AnagramComparator());
		//System.out.println(Arrays.toString(test));
		assertTrue(Arrays.equals(test, correct));
	}
	
	@Test 
	void testInsertionSortTwo(){
		String[] test = new String[] {"rat","apple","tar"};
		String[] correct = new String[] {"rat","tar","apple",};
		AnagramChecker.insertionSort(test, new AnagramComparator());
		//System.out.println(Arrays.toString(test));
		assertTrue(Arrays.equals(test, correct));
	}
	
	//TEST AREANAGRAMS
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
	
	//TEST GETLARGESTANAGRAM
	@Test
	void testGetLargestAnagramGroup() {
		String[] test = new String[] {"enlist","glare","listen","silent","large"};
		String[] correct = new String[] {"enlist","listen","silent"};		
		//System.out.println(Arrays.toString(correct));
		//System.out.println(Arrays.toString(AnagramChecker.getLargestAnagramGroup(test)));
		assertTrue(Arrays.equals(AnagramChecker.getLargestAnagramGroup(test), correct));
		
	}
	@Test
	void testGetLargestAnagramGroupCapitals() {
		String[] test = new String[] {"Enlist","glare","listen","Silent","large"};
		String[] correct = new String[] {"Enlist","listen","Silent"};		
		//System.out.println(Arrays.toString(correct));
		//System.out.println(Arrays.toString(AnagramChecker.getLargestAnagramGroup(test)));
		assertTrue(Arrays.equals(AnagramChecker.getLargestAnagramGroup(test), correct));
		
	}
	@Test
	void testGetLargestAnagramGroupNull() {
		String[] test = new String[] {"glare","listen","carets"};
		String[] correct = new String[] {};		
		//System.out.println(Arrays.toString(correct));
		//System.out.println(Arrays.toString(AnagramChecker.getLargestAnagramGroup(test)));
		assertTrue(Arrays.equals(AnagramChecker.getLargestAnagramGroup(test), correct));
		
	}
	
	@Test
	void testGetlargestAnagramGroupFile() throws FileNotFoundException {
		String filename = "/Users/cp/Downloads/sample_word_list.txt";
		String[] correct = new String[] {"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"};
		//System.out.println(Arrays.toString(AnagramChecker.getLargestAnagramGroup(filename)));
		assertTrue(Arrays.equals(AnagramChecker.getLargestAnagramGroup(filename), correct));
		
	}
	@Test
	void testGetlargestAnagramGroupEmptyFile() throws FileNotFoundException {
		String filename = "/Users/cp/Downloads/sample.txt";
		String[] correct = new String[] {};
		//System.out.println(Arrays.toString(AnagramChecker.getLargestAnagramGroup(filename)));
		assertTrue(Arrays.equals(AnagramChecker.getLargestAnagramGroup(filename), correct));
		
	}

}
