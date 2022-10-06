package assign05;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Jonah Matousek and Casey Parker
 *
 */

public class ArrayListSorter {
	private static int threshold = 5;

	/**
	 * @param <T>
	 * @param list - list of objects that is to be sorted
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
		ArrayList<T> temp = new ArrayList<T>(list.size());
		for (int i = 0; i < list.size(); i++) {
			temp.add(list.get(i));
		}
		int start = 0;
		int end = list.size() - 1;
		
		mergesort(list, temp, start, end);
	}

	/**
	 * @param <T>
	 * @param list  - list of objects that is to be sorted
	 * @param temp  - temp list that is the same length as list
	 * @param start - starting index
	 * @param end   - ending index
	 */
	private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list, ArrayList<T> temp, int start,
			int end) {
		if (end - start <= threshold)
			insertionSort(list, temp, start, end);
		else {
			int mid = (start + end) / 2;
			mergesort(list, temp, start, mid);
			mergesort(list, temp, mid + 1, end);
			merge(list, temp, start, mid + 1, end);
		}

	}

	/**
	 * 
	 * @param <T>
	 * @param list  - list of objects that is to be sorted
	 * @param temp  - temp list that is the same length as list
	 * @param start - starting index
	 * @param mid   - middle index
	 * @param end   - ending index
	 */
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> list, ArrayList<T> temp, int start,
			int mid, int end) {
		int listIndex = start;
		int i1 = start;
		int i2 = mid;
		// merges the sections of the array
		while (i1 < mid && i2 <= end) {
			if (list.get(i1).compareTo(list.get(i2)) == -1) {
				temp.set(listIndex, list.get(i1));
				listIndex++;
				i1++;
			} else {
				temp.set(listIndex, list.get(i2));
				listIndex++;
				i2++;
			}
		}
		// adds left over items(only one of these while loops will do something in a
		// single pass)
		while (i1 < mid) {
			temp.set(listIndex, list.get(i1));
			listIndex++;
			i1++;
		}
		while (i2 <= end) {
			temp.set(listIndex, list.get(i2));
			listIndex++;
			i2++;
		}
		// copy sorted items from temp to list
		for (int i = start; i <= end; i++) {
			list.set(i, temp.get(i));
		}
	}

	/**
	 * 
	 * @param <T>
	 * @param list  - list of objects that is to be sorted
	 * @param temp  - temp list that is the same length as list
	 * @param start - starting index
	 * @param end   - ending index
	 */
	private static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> list, ArrayList<T> temp, int start,
			int end) {
		int sortedIndex;
		for (int sortedLength = start + 1; sortedLength <= end; sortedLength++) {
			sortedIndex = sortedLength - 1;
			temp.set(sortedLength, list.get(sortedLength));
			while (sortedIndex >= start) {
				if (temp.get(sortedLength).compareTo(list.get(sortedIndex)) == -1) {
					list.set(sortedIndex + 1, list.get(sortedIndex));
					list.set(sortedIndex, temp.get(sortedLength));
					sortedIndex--;
				} else {
					sortedIndex--;
				}
			}
		}}

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
	public static ArrayList<Integer> generateAscending(int size) {
		ArrayList<Integer> out = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			out.add(i);

		}

		return out;

	}

	/**
	 * @param size list length
	 * @return returns permutted int list
	 */
	public static ArrayList<Integer> generatePermuted(int size) {
		ArrayList<Integer> out = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			out.add(i);

		}
		Collections.shuffle(out);

		return out;

	}

	/**
	 * @param size list length
	 * @return decending int list
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		ArrayList<Integer> out = new ArrayList<>();
		for (int i = size; i > 0; i--) {
			out.add(i);

		}

		return out;
	}

}
