package assign07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TimingExperiment1 {
	private static Random rand;

	public static void main(String[] args) {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		int timesToLoop = 1000;

		// Initial size, final size, step size
		for (int n = 100; n <= 2000; n += 100) {

			// Generate a new "random" ArrayCollection of size n.
//			BinarySearchTree<Integer> treeO = new BinarySearchTree<>(); // ordered
			ArrayList<Integer> array = new ArrayList<Integer>(n); // random

			for (int i = 0; i < n; i++) {
//				treeO.add(i); // ordered
				array.add(i); // random
			}

			Collections.shuffle(array); // random
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
//					treeO.contains(i); // ordered
					treeR.contains(i); // random
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
			System.out.println(n + "\t" + averageTime);
		}
	}
}
