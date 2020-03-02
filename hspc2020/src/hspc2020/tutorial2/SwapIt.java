package hspc2020.tutorial2;

import java.util.Scanner;

public class SwapIt {
	
	private static int swapToTheMax(int n) {
		//YOUR CODE HERE
		return n;
		//YOUR CODE HERE
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			int n = sc.nextInt();
			assert n > 0 : "Must be a positive integer";
			sc.nextLine();
			
			System.out.println(swapToTheMax(n));	
		}

		sc.close();
	}
}
