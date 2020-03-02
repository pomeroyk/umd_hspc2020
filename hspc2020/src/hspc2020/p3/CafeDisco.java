package hspc2020.p3;

import java.util.Scanner;

public class CafeDisco {

	private static boolean runCafeDisco(int len, int[] nums) {
		//YOUR CODE HERE
		return false;
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
