package hspc2020.p5;

import java.util.Scanner;

public class Accounting {
	
	private static String getMatch(String master, String search) {
		//YOUR CODE HERE
		String minMatch =  "";
		return minMatch;
		//YOUR CODE HERE
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			String master = sc.next();
			String search = sc.next();
			
			System.out.println(
					getMatch(master, search)
					);
		}

		sc.close();
	}
}
