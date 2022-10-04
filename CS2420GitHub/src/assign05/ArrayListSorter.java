package assign05;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorter {

	/**
	 * @param <T>
	 * @param list
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
		
	}
	
	/**
	 * @param <T>
	 * @param list
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list) {
		
		
		
	}
	
	/**
	 * @param size list length
	 * @return return acending int list
	 */
	public static ArrayList<Integer> generateAscending(int size){
		ArrayList<Integer> out  = new ArrayList<>();
		for(int i = 0; i < size;i++) {
			out.add(i);
			
		}
		
		return out;
		
	}
	
	/**
	 * @param size list length
	 * @return returns permutted int list
	 */
	public static ArrayList<Integer> generatePermuted(int size){
		ArrayList<Integer> out  = new ArrayList<>();
		for(int i = 0; i < size;i++) {
			out.add(i);
			
		}
		Collections.shuffle(out);
		
		return out;
		
	}
	
	/**
	 * @param size list length
	 * @return decending int list
	 */
	public static ArrayList<Integer> generateDescending(int size){
		ArrayList<Integer> out  = new ArrayList<>();
		for(int i = size; i > 0;i--) {
			out.add(i);
			
		}
		
		return out;
	}
	
	
}
