package hspc2020.p6;

import java.util.ArrayList;
import java.util.Scanner;

//Thanks to Leetcode user @awice for this solution!

public class FamousChili_solution {

	private static boolean makeChili(int[] stock) {

		final int stockLen = 4;
		ArrayList<Double> stockD = new ArrayList<Double>();
		for(int idx=0; idx<stockLen; idx++) {
			stockD.add((double)stock[idx]);
		}
		return makeChiliArrayList(stockD);
	}
	
	private static boolean makeChiliArrayList(ArrayList<Double> stockD) {

		//YOUR CODE HERE
		if(stockD.size() == 0) return false;
		if(stockD.size() == 1) return Math.abs(stockD.get(0) - 24) < 1e-6;

		for(int i = 0; i < stockD.size(); i++) {
			for(int j = 0; j < stockD.size(); j++) {
				if (i != j) {
					ArrayList<Double> nums2 = new ArrayList<Double>();
					for(int k = 0; k < stockD.size(); k++) if (k != i && k != j) {
						nums2.add(stockD.get(k));
					}
					for (int k = 0; k < 4; k++) {
						if (k < 2 && j > i) continue;
						if (k == 0) nums2.add(stockD.get(i) + stockD.get(j));
						if (k == 1) nums2.add(stockD.get(i) * stockD.get(j));
						if (k == 2) nums2.add(stockD.get(i) - stockD.get(j));
						if (k == 3) {
							if (stockD.get(j) != 0) {
								nums2.add(stockD.get(i) / stockD.get(j));
							} else {
								continue;
							}
						}
						if(makeChiliArrayList(nums2)) return true;
						nums2.remove(nums2.size() - 1);
					}
				}
			}
		}
		return false;
		//YOUR CODE HERE

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			int[] stock = new int[4];
			for (int idx=0; idx<4; idx++) {
				stock[idx] = sc.nextInt();
			}
			sc.nextLine();

			System.out.println("Kevin's chili is " +
					(makeChili(stock) ? "going to be" : "not going to be") +
					" great this year."
					);
		}

		sc.close();
	}
}
