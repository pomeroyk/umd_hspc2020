package hspc2020.tutorial3;

import java.util.Scanner;

public class LongParens {

	private static int longestValid(String parens) {
		//YOUR CODE HERE
		return -1;
		//YOUR CODE HERE
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			String parens = sc.next();
			sc.nextLine();
			
			System.out.println(longestValid(parens));	
		}

		sc.close();
	}
}
