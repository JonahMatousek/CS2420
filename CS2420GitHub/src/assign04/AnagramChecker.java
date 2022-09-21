package assign04;

import java.util.Comparator;

public class AnagramChecker {
	/*
	 * This method returns the lexicographically-sorted version of the input string.
	 * The sorting must be accomplished using an insertion sort.
	 */
	public static String sort(String word) {
		char[] chars = word.toCharArray();
		for (int i : chars) {
			int temp  = i--;
			char val = chars[i];
			
			while(temp >= 0 && chars[temp] > val) {
				chars[temp+1] = chars[temp];
				temp--;
			}
			chars[temp+1] = val;
				
		}
		
		return chars.toString();
		
		
	}

	/*
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 */
	public static <T> void insertionSort(T[] list, Comparator<? super T> cmp) {
		for(int i=0;i<list.length;i++) {
			int temp = i--;
			T val = list[i];
			
			while(temp >= 0 && cmp.compare(list[temp],val)>0) { //change for cmp
				list[temp+1] = list[temp];
				temp--;
			}
			list[temp+1] = val;
			
		}
		
	}

	/*
	 * This method returns true if the two input strings are anagrams of each other,
	 * otherwise returns false. This method must call your sort(String) method.
	 */
	public static boolean areAnagrams(String wordOne, String wordTwo) {
		if (wordOne.length() != wordTwo.length())
			return false;
		//int half = wordOne.length()/2;
		boolean out = true;
		for (int i = 0; i<wordOne.length();i++) {
			if (wordOne.charAt(i)!=wordTwo.charAt(i)) {
				out = false;
			}
		}
		
		return out;
	}

	/*
	 * This method returns the largest group of anagrams in the input array of
	 * words, in no particular order. It returns an empty array if there are no
	 * anagrams in the input array. This method must call your areAnagrams(String,
	 * String) method and your insertionSort(T[], Comparator) method with a new
	 * Comparator class or lambda expression that you design.
	 */
	public static String[] getLargestAnagramGroup(String[] wordList) {
		insertionSort(wordList,new AnagramComparator()) ;
		ArrayList<String> largestAnagramGroup = new ArrayList<>(); 
			
		
		for (int i=0;i<wordList.length;i++) {
			
			if(areAnagrams(wordList[i],wordList[i+1])){
				if(!largestAnagramGroup.contains(wordList[i]) || !largestAnagramGroup.contains(wordList[i+1])) {
				largestAnagramGroup.add(wordList[i]);
				largestAnagramGroup.add(wordList[i+1]);
			}
		}
		
	}
		return (String[]) largestAnagramGroup.toArray();
		
	}

	/*
	 * This method behaves the same as the previous method, but reads the list of
	 * words from the input filename. It is assumed that the file contains one word
	 * per line. If the file does not exist or is empty, the method returns an empty
	 * array because there are no anagrams. This method must call your
	 * getLargestAnagramGroup(String[]) method.
	 */
	public static String[] getLargestAnagramGroup(String filename) {
		return null;
	}

}
