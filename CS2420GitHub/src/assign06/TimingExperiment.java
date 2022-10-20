package assign06;

import java.util.Random;

public class TimingExperiment {
	private static Random rand;

	public static void main(String[] args) {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		int timesToLoop = 20000;

		// Initial size, final size, step size
		for (int n = 1000; n <= 20000; n += 1000) {
			// Generate a new "random" ArrayCollection of size n.

			int num;

			long startTime, midpointTime, stopTime;
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}
			// Now, run the test.
			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++) {

				LinkedListStack<Integer> lls = new LinkedListStack<Integer>();
				ArrayStack<Integer> as = new ArrayStack<Integer>();
//				for (int x = 0; x < n; x++) {
				num = rand.nextInt(100);
//				lls.push(num);
					as.push(num);
//				}

				for (int x = 0; x < n; x++) {

//					lls.pop();
//					as.pop();
//				lls.peek();
				as.peek();
				}


			}
			midpointTime = System.nanoTime();
			// Run a loop to capture the cost of running the "timesToLoop" loop
			// and extra costs
			for (int i = 0; i < timesToLoop; i++) {

//				LinkedListStack<Integer> lls = new LinkedListStack<Integer>();
				ArrayStack<Integer> as = new ArrayStack<Integer>();
//				for (int x = 0; x < n; x++) {
				num = rand.nextInt(100);
//				lls.push(num);
				as.push(num);
//				}
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
