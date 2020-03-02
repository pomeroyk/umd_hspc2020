package hspc2020.p5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Thanks to Leetcode user @godayaldivya for this solution!

public class Accounting_solution {

	private static String getMatch(String master, String search) {
		//YOUR CODE HERE
		
		// No matches for the trivial cases (master string, slave string)
		if (master.length() == 0 || search.length() == 0) {
			return "";
		}

		// Dictionary which keeps a count of all the unique characters in search.
		Map<Character, Integer> dictT = new HashMap<Character, Integer>();
		for (int i = 0; i < search.length(); i++) {
			int count = dictT.getOrDefault(search.charAt(i), 0);
			dictT.put(search.charAt(i), count + 1);
		}

		// Number of unique characters in search,
		// which need to be present in the desired window.
		int required = dictT.size();

		// Left and Right pointer (sliding window)
		int l = 0, r = 0;

		// formed is used to keep track of how many unique characters in search
		// are present in the current window in its desired frequency.
		// e.g. if search is "AABC" then the window must have two A's, one B and one C.
		// Thus formed would be = 3 when all these conditions are met.
		int formed = 0;

		// Dictionary which keeps a count of all the unique characters in the current window.
		Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

		// ans list of the form (window length, left, right)
		int[] ans = {-1, 0, 0};

		while (r < master.length()) {
			
			// Add one character from the right to the window
			char c = master.charAt(r);
			int count = windowCounts.getOrDefault(c, 0);
			windowCounts.put(c, count + 1);

			// If the frequency of the current character added equals to the
			// desired count in search then increment the formed count by 1.
			if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
				formed++;
			}

			// Try and contract the window till the point where it ceases to be 'desirable'.
			while (l <= r && formed == required) {
				c = master.charAt(l);
				// Save the smallest window until now.
				if (ans[0] == -1 || r - l + 1 < ans[0]) {
					ans[0] = r - l + 1;
					ans[1] = l;
					ans[2] = r;
				}

				// The character at the position pointed by the
				// `Left` pointer is no longer a part of the window.
				windowCounts.put(c, windowCounts.get(c) - 1);
				if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
					formed--;
				}

				// Move the left pointer ahead, this would help to look for a new window.
				l++;
			}

			// Keep expanding the window once we are done contracting.
			r++;   
		}

		return ans[0] == -1 ? "" : master.substring(ans[1], ans[2] + 1);
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
