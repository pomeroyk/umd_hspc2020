package hspc2020.p4;

import java.util.Scanner;

public class MindfulDrienf_solution {

	private static long factorial(int val) {
		long result=1;
		for (int n=2; n<=val; n++) {
			result*=n;
		}
		return result;
	}

	private static long countCombos(String name) {
		//YOUR CODE HERE

		int[] ascii = new int[128];
		char[] letters = name.toCharArray();
		for (int pos=0; pos<letters.length; pos++) {
			ascii[letters[pos]]++;
		}

		long divisor=1;
		for (int pos='a'; pos<'z'; pos++) {
			if (ascii[pos]>1) {
				divisor*=factorial(ascii[pos]);
			}
		}

		long result;
		int spaces = ascii[' '];
		int words = 1+spaces;

		if (words==1) {
			result = factorial(name.length()-1)/divisor;
		}
		else {
			//System.out.println(factorial(name.length()-words-spaces)/divisor);
			//System.out.println(factorial(words));
			//System.out.println( (factorial(name.length()-2)/factorial(name.length()-2-(words-1))) );
			result = 
					factorial(name.length()-words-spaces)/divisor * 
					factorial(words) *   //positions for first letters
					(factorial(name.length()-2)/factorial(name.length()-2-(words-1)));   
		}

		return result; 

		//YOUR CODE HERE
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 
			String name = sc.nextLine();
			System.out.println(
					"Name " + name + 
					" can generate " +
					countCombos(name) +
					" unique possibilities."
					);
		}

		sc.close();
	}

}

