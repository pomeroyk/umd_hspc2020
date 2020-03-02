package hspc2020.p8;

import java.util.*;

/** DrawCubicles - Code stub
 */

public class DrawCubicles {

	/**
	 * Main Program - Read the input and output the final answer.
	 */
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		try {
			int numTrials = scanner.nextInt(); // number of trials to run

			for (int t = 1; t <= numTrials; t++) {

				int w = scanner.nextInt(); // get initial width and height
				int h = scanner.nextInt();

				String restOfLine = scanner.nextLine(); // remainder of this line
				Scanner lineScanner = new Scanner(restOfLine);

				ArrayList<String> hcpList = new ArrayList<String>();
				while (lineScanner.hasNext()) { // copy rest of line into HCP list
					hcpList.add(lineScanner.next());
				}

				lineScanner.close(); // done with the scanner

				System.out.println("Drawing " + t); // which trial
				drawCubicles(w, h, hcpList); // generate and draw the cubicles
			}
		} catch (Exception e) {
			System.err.println("Something went wrong: " + e.toString());
		} finally { // close the scanner
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	/** 
	 * Generate and print the cubicles described in the HCP list.
	 */
	private static void drawCubicles(int w, int h, ArrayList<String> hcpList)
	{
		// <--- Your code goes here --->
	}
}
