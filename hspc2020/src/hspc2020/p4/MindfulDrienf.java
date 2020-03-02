package hspc2020.p4;

import java.util.Scanner;

public class MindfulDrienf {

	private static long countCombos(String name) {
		//YOUR CODE HERE
		return -1;
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
