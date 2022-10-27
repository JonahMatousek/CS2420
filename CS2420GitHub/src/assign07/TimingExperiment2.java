package assign07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class TimingExperiment2 {
	private static Random rand;

	public static void main(String[] args) {
		String treeset = "TreeSet:\n";
		String bst = "BST:\n";

		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		int timesToLoop = 1000;

		// Initial size, final size, step size
		for (int n = 100; n <= 2000; n += 100) {

			// Generate a new "random" ArrayCollection of size n.
			ArrayList<Integer> array = new ArrayList<Integer>(n);

			for (int i = 0; i < n; i++) {
				array.add(i);
			}
			Collections.shuffle(array);
			BinarySearchTree<Integer> treeR = new BinarySearchTree<Integer>();
			treeR.addAll(array);

			long startTime, midpointTime, stopTime;
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}
			// Now, run the test.
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				for (int x = 0; x < n; x++) {
					treeR.contains(i);
				}
			}
			midpointTime = System.nanoTime();
			// Run a loop to capture the cost of running the "timesToLoop" loop
			// and extra costs
			for (int i = 0; i < timesToLoop; i++) {
				for (int x = 0; x < n; x++) {

				}
			}
			stopTime = System.nanoTime();
			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
			bst += n + "\t" + averageTime + "\n";
			System.out.println("BST: " + n);
		

			// Generate a new "random" ArrayCollection of size n.
			ArrayList<Integer> array2 = new ArrayList<Integer>(n);

			for (int i = 0; i < n; i++) {
				array2.add(i);
			}
			Collections.shuffle(array2);
			TreeSet<Integer> treeR2 = new TreeSet<Integer>();
			treeR2.addAll(array2);

			long startTime2, midpointTime2, stopTime2;
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime2 = System.nanoTime();
			while (System.nanoTime() - startTime2 < 1000000000) { // empty block
			}
			// Now, run the test.
			startTime2 = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				for (int x = 0; x < n; x++) {
					treeR2.contains(i);
				}
			}
			midpointTime2 = System.nanoTime();
			// Run a loop to capture the cost of running the "timesToLoop" loop
			// and extra costs
			for (int i = 0; i < timesToLoop; i++) {
				for (int x = 0; x < n; x++) {

				}
			}
			stopTime2 = System.nanoTime();
			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime2 = ((midpointTime2 - startTime2) - (stopTime2 - midpointTime2)) / (double) timesToLoop;
			treeset += n + "\t" + averageTime2 + "\n";
			System.out.println("TreeSet: " + n);
		}
		System.out.println(bst);
		System.out.println();
		System.out.println(treeset);
	}
}
