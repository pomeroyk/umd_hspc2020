package hspc2020.p2;

import java.util.Scanner;

public class PurrfectAuction_solution {

	private static boolean isImpurrfectNumber(int num) {
		// Impurrfect numbers are the product of an integer with itself
		return (Math.pow((int)(Math.sqrt(num)),2) == num);
	}

	private static boolean isPurrfect(int n) 
	{ 
		// Inputs less than 2 cannot be purrfect
		if( n <= 1) { return false; }

		// Accumulate divisors; 1 is shared divisor, so seed with that
		int sum = 1; 

		// Accumulate each additional divisor
		for(int i = 2; i * i <= n; i++) { 
			if(n % i==0) { 
				if(i * i != n) 
					sum += i + n / i; 
				else
					sum += i; 
			} 
		}  

		// If 2 + sum divisors == n, then return purrfect
		return (sum+2) == n;
	} 

	private static int runPurrfectAuction(int numAgents, int numItems, int[][] bids) {
		//YOUR CODE HERE
		int totalRevenue = 0;

		// Compute revenue for each item separately
		for(int item=0; item<numItems; item++) {

			// Individual item's revenue is the max across all agents' bids
			// for that item
			int itemRevenue = -1;
			for(int agent=0; agent<numAgents; agent++) {
				int currBid = bids[agent][item];

				// If any agent bids purrfectly, Angela short circuits the
				// auction for that item and charges $0
				if(isPurrfect(currBid)) {
					itemRevenue = 0;
					break;
				}

				if(currBid > itemRevenue) {
					itemRevenue = currBid;
				}
			}

			// If the winning bid is impurrfect, Angela charges the bidder
			// twice their bid.  (Special case of $0 is unaffected.)
			if(isImpurrfectNumber(itemRevenue)) {
				itemRevenue *= 2;
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
					runPurrfectAuction(numAgents, numItems, bids)
					);
		}

		sc.close();
	}
}
