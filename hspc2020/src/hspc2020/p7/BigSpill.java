package hspc2020.p7;

import java.util.Scanner;

public class BigSpill {

	public static int countChili(int len, int[] elevation) {
		//YOUR CODE HERE
		return -1;
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
