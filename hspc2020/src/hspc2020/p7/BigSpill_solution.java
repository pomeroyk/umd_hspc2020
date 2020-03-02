package hspc2020.p7;

import java.util.Scanner;

public class BigSpill_solution {

	public static int countChili(int len, int[] elevation) {
		//YOUR CODE HERE
		int chiliCount = 0;
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];
		leftMax[0] = elevation[0];

		for(int idx = 1; idx < len; idx++) {
			leftMax[idx] = Math.max(elevation[idx], leftMax[idx - 1]);
		}

		rightMax[len - 1] = elevation[len - 1];
		for(int idx = len - 2; idx >= 0; idx--) {
			rightMax[idx] = Math.max(elevation[idx], rightMax[idx + 1]);
		}
		
		for(int idx = 1; idx < len - 1; idx++) {
			chiliCount += Math.min(leftMax[idx], rightMax[idx]) - elevation[idx];
		}
		return chiliCount;
		//YOUR CODE HERE
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			int len = sc.nextInt();
			assert len > 0 : "Illegal length";

			int[] elevation = new int[len];
			for (int idx=0; idx<len; idx++) {
				elevation[idx] = sc.nextInt();
			}
			sc.nextLine();

			System.out.println(
					countChili(len, elevation)
					);
		}

		sc.close();
	}
}
