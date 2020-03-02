package hspc2020.p3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Thanks to Leetcode user @awice for this solution!

public class CafeDisco_solution {
	
	private static boolean runCafeDisco(int len, int[] nums) {
		//YOUR CODE HERE
		
		// count[x] = the number of occurrences of x in nums
	    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
	    for(int idx=0; idx<len; idx++) {
	    	int num = nums[idx];
	        count.put(num, count.getOrDefault(num, 0) + 1);
	    }
	    
	    // redoubledNums = nums as Integer[], sorted by absolute value
	    Integer[] redoubledNums = new Integer[len];
	    for (int i = 0; i < len; ++i)
	        redoubledNums[i] = nums[i];

	    Arrays.sort(redoubledNums, new Comparator<Integer>() {
	    	@Override
	    	public int compare(Integer i1, Integer i2) {
	    		return ((Integer) Math.abs(i1)).compareTo(Math.abs(i2));
	    	}
	    });

	    for (int x : redoubledNums) {
	        // If this can't be consumed, skip
	        if (count.get(x) == 0) { continue; }
	        // If this doesn't have a doubled partner, the answer is false
	        if (count.getOrDefault(2*x, 0) <= 0) { return false; }

	        // Write x, 2*x
	        count.put(x, count.get(x) - 1);
	        count.put(2*x, count.get(2*x) - 1);
	    }

	    // If we have written everything, the answer is true
	    return true;
		//YOUR CODE HERE

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			int len = sc.nextInt();
			assert len > 0 : "Illegal length";

			int[] nums = new int[len];
			for (int idx=0; idx<len; idx++) {
				nums[idx] = sc.nextInt();
			}
			sc.nextLine();

			System.out.println("This conga line " +
					(runCafeDisco(len, nums) ? "can" : "cannot") +
					" be redoubled."
					);
		}

		sc.close();
	}
}
