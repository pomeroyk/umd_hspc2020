package hspc2020.tutorial1;

import java.util.Scanner;

public class Points {

	private static int countPoints(int len, String[] ops) {
		//YOUR CODE HERE
		return 0;
		//YOUR CODE HERE
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			int len = sc.nextInt();
			assert len > 0 : "Illegal length";

			String[] ops = new String[len];
			for (int idx=0; idx<len; idx++) {
				ops[idx] = sc.next();
			}
			sc.nextLine();

			System.out.println(
					countPoints(len, ops)
					);
		}

		sc.close();
	}
}
