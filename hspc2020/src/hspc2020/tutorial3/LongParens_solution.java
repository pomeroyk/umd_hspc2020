package hspc2020.tutorial3;

import java.util.Scanner;

// Lots of good solutions: https://leetcode.com/problems/longest-valid-parentheses/solution/

public class LongParens_solution {
	
	private static int longestValid(String parens) {
		//YOUR CODE HERE
		int max = 0;
		int dp[] = new int[parens.length()];
		for(int i = 1; i < parens.length(); i++) {
			if(parens.charAt(i) == ')') {
				if(parens.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if(i - dp[i - 1] > 0 && parens.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
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
