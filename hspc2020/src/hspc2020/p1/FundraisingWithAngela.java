package hspc2020.p1;

import java.util.Scanner;

public class FundraisingWithAngela {

	private static int runSimpleAuction(int numAgents, int numItems, int[][] bids) {
		
		//YOUR CODE HERE
		return -1;
		//YOUR CODE HERE
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 
			
			int numAgents = sc.nextInt();
			int numItems = sc.nextInt();
			
			int[][] bids = new int[numAgents][numItems];
			for (int agent=0; agent<numAgents; agent++) {
				for (int item=0; item<numItems; item++) {
					bids[agent][item] = sc.nextInt();
				}
				sc.nextLine();
			}
			
			System.out.println(
					runSimpleAuction(numAgents, numItems, bids)
					);
		}

		sc.close();
	}
}
