/**
 * 
 */
package assign05;

import java.util.Random;


/**
 * @author jonah
 *
 */
public class MergeSortTiming {
	private static Random rand;

	public static void main(String[] args) {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		int timesToLoop = 10000;

		// Initial size, final size, step size
		for (int n = 10; n <= 200; n += 10) {
			// Generate a new "random" ArrayCollection of size n.
			

			long startTime, midpointTime, stopTime;
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}
			// Now, run the test.
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				
				
				
			}
			midpointTime = System.nanoTime();
			// Run a loop to capture the cost of running the "timesToLoop" loop
			// and extra costs
			for (int i = 0; i < timesToLoop; i++) {
				
				
				
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
