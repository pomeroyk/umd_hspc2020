package hspc2020.tutorial0;

import java.util.Scanner;

public class FizzBuzz_solution {

	private static String[] doFizzBuzz(int n) {
		String[] reps = new String[n];
		//YOUR CODE HERE
		for(int i=1; i<=n; i++) {
			if(i % 3 == 0) {
				if(i % 5 == 0) {
					reps[i-1] = "FizzBuzz";
				} else {
					reps[i-1] = "Fizz";
				}
			} else if(i % 5 == 0) {
				reps[i-1] = "Buzz";
			} else {
				reps[i-1] = String.valueOf(i);
			}
		}
		//YOUR CODE HERE
		return reps;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			int n = sc.nextInt();
			assert n > 0 : "Must be a positive integer";
			sc.nextLine();

			String[] reps = doFizzBuzz(n);
			for(String rep : reps) {
				System.out.print(rep + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}
