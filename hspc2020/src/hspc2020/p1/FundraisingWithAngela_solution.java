package hspc2020.p1;

import java.util.Scanner;

public class FundraisingWithAngela_solution {

	private static int runSimpleAuction(int numAgents, int numItems, int[][] bids) {
		
		//YOUR CODE HERE
		int totalRevenue = 0;
		
		// Compute revenue for each item separately
		for(int item=0; item<numItems; item++) {
			
			// Individual item's revenue is the max across all agents' bids
			// for that item
			int itemRevenue = -1;
			for(int agent=0; agent<numAgents; agent++) {
				int currBid = bids[agent][item];
				if(currBid > itemRevenue) {
					itemRevenue = currBid;
				}
			}
			
			totalRevenue += itemRevenue;
		}
		return totalRevenue;
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
