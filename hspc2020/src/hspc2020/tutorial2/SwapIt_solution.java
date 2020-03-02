package hspc2020.tutorial2;

import java.util.Arrays;
import java.util.Scanner;

public class SwapIt_solution {

	private static int swapToTheMax(int n) {
		//YOUR CODE HERE

		// Brute force solution -- we know n is at most 10^8, i.e., is at most
		// 8 digits long, which yields 8*7/2 = 28 possible swaps.  Try them all!
		char[] A = Integer.toString(n).toCharArray();
		char[] ans = Arrays.copyOf(A, A.length);

		for(int i = 0; i < A.length; i++) {
			for(int j = i+1; j < A.length; j++) {
				char tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
				for(int k = 0; k < A.length; k++){
					if(A[k] != ans[k]){
						if(A[k] > ans[k]) {
							ans = Arrays.copyOf(A, A.length);
						}
						break;
					}
				}
				A[j] = A[i];
				A[i] = tmp;
			}
		}
		return Integer.valueOf(new String(ans));
		//YOUR CODE HERE
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			int n = sc.nextInt();
			assert n >= 0 : "Must be a nonnegative integer";
			sc.nextLine();

			System.out.println(swapToTheMax(n));	
		}

		sc.close();
	}
}
