package assign04;

import java.util.ArrayList;
import java.util.Random;



public class AnagramTimingGroup {
	private static ArrayList<String> generateStringArray(int size){
		String[] alpha = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m"};
		ArrayList<String> stringArrayRand = new ArrayList<>();
		while(stringArrayRand.size()< size) {
			String newString = "";
			while(newString.length()< 10) {
				newString+=(alpha[rand.nextInt(13)]);
				
			}
			stringArrayRand.add(newString);
		}
		return stringArrayRand;
		
	}
	private static Random rand;
	public static void main(String[] args)
	{
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
	
		//TODO: Write code to time your toSortedList, contains, and SearchUtil.binarySearch methods so you can plot the results.
		int timesToLoop = 5000;
		
		for (int n = 1000; n <= 20000; n += 1000) {
			// Generate a new "random" ArrayCollection of size n.
			String[] StringArray = generateStringArray(n).toArray(new String[0]);
			
			//String val1 = StringArray[rand.nextInt(n)];
			//String val2 = StringArray[rand.nextInt(n)];
			long startTime, midpointTime, stopTime;
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}
			// Now, run the test.
			startTime = System.nanoTime();
			for (int i = 0; i < timesToLoop; i++) {
				AnagramChecker.getLargestAnagramGroup(StringArray);
			}
			midpointTime = System.nanoTime();
			// Run a loop to capture the cost of running the "timesToLoop" loop 
			//and
			// generating a random ISBN.
			for (int i = 0; i < timesToLoop; i++) {
			
			}
			stopTime = System.nanoTime();
			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - 
			midpointTime))
			/ (double) timesToLoop;
			System.out.println(n + "\t" + averageTime);
			}
	}

	

	public static Integer randomInt()
	{
		return rand.nextInt();
	}
}


