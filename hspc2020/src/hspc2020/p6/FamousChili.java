package hspc2020.p6;

import java.util.Scanner;

public class FamousChili {
	
	private static boolean makeChili(int[] stock) {
		//YOUR CODE HERE
		return false;
		//YOUR CODE HERE
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			int[] stock = new int[4];
			for (int idx=0; idx<4; idx++) {
				stock[idx] = sc.nextInt();
			}
			sc.nextLine();

			System.out.println("Kevin's chili is " +
					(makeChili(stock) ? "going to be" : "not going to be") +
					" great this year."
					);
		}

		sc.close();
	}
}
