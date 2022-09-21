package assign04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AnagramChecker {
	/*
	 * This method returns the lexicographically-sorted version of the input string.
	 * The sorting must be accomplished using an insertion sort.
	 */
	public static String sort(String word) {
		char[] chars = word.toCharArray();
		for (int i : chars) {
			int temp = i--;
			char val = chars[i];

			while (temp >= 0 && chars[temp] > val) {
				chars[temp + 1] = chars[temp];
				temp--;
			}
			chars[temp + 1] = val;

		}

		return chars.toString();

	}

	/*
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 */
	public static <T> void insertionSort(T[] list, Comparator<? super T> cmp) {
		for (int i = 0; i < list.length; i++) {
			int temp = i--;
			T val = list[i];

			while (temp >= 0 && cmp.compare(list[temp], val) > 0) { // change for cmp
				list[temp + 1] = list[temp];
				temp--;
			}
			list[temp + 1] = val;

		}

	}

	/*
	 * This method returns true if the two input strings are anagrams of each other,
	 * otherwise returns false. This method must call your sort(String) method.
	 */
	public static boolean areAnagrams(String wordOne, String wordTwo) {

		if (sort(wordOne).compareToIgnoreCase(sort(wordTwo)))
			return true;

		return false;
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
		ArrayList<String> currentAnagramGroup = new ArrayList<>();
		
		for (int i=0;i<wordList.length;i++) {
			if(i+1<wordList.length()){
				if(areAnagrams(wordList[i],wordList[i+1])){
					if(!currentAnagramGroup.contains(wordList[i])) {
					currentAnagramGroup.add(wordList[i]);
					}
					if(!currentAnagramGroup.contains(wordList[i+1])){
					currentAnagramGroup.add(wordList[i+1]);
					}
			
				}else{
					if(currentAnagramGroup.size()>largestAnagramGroup.size()){
						largestAnagramGroup = currentAnagramGroup;
					}
					currentAnagramGroup.clear();
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
		ArrayList<String> wordList = new ArrayList<String>;
		File file = new File(filename);
		Scanner fs = new Scanner(file);
		while (fs.hasNextLine())
			wordList.add(fs.nextLine());
		String[] wordListInput = wordList.toArray();
		
		return getLargestAnagramGroup(wordList);
	}

}

class AnagramComparator implements Comparator<String> {

	@Override
	public int compare(String one, String two) {
		if (AnagramChecker.sort(one).compareTo(AnagramChecker.sort(two)) > 0) {
			return 1;
		} else if (AnagramChecker.sort(one).compareTo(AnagramChecker.sort(two)) < 0) {
			return -1;
		} else
			return 0;
	}

}
