package hspc2020.p8;



//----------------------------------------------------------------------
//Best viewed with tabs every 4 columns
//----------------------------------------------------------------------

import java.util.*;

/** DrawCubicles
 *
 * This program computes and draws a hierarchical cubicle partition. 
 * A cubicle partition is defined as follows.
 *
 * We start with a rectangular office space that is w feet wide (along
 * the x-axis) and h feet high (along the y-axis). A vertical cut of
 * size s, where s in [1,w-1], splits the rectangle into a left rectangle
 * of width s and a right rectangle of width w-s. A horizontal cut of
 * size s, where s in [1,h-1], splits the rectangle into a lower
 * rectangle of height s and an upper rectangle of height h-s.
 * 
 * width=6, height=4      Vertical 2-split       Horizontal 3-split
 * 
 * +--+--+--+--+--+--+    +--+--+--+--+--+--+    +--+--+--+--+--+--+
 * |                 |    |     |           |    |                 |
 * +  +  +  +  +  +  +    +  +  +  +  +  +  +    +--+--+--+--+--+--+
 * |                 |    |     |           |    |                 |
 * +  +  +  +  +  +  +    +  +  +  +  +  +  +    +  +  +  +  +  +  +
 * |                 |    |     |           |    |                 |
 * +  +  +  +  +  +  +    +  +  +  +  +  +  +    +  +  +  +  +  +  +
 * |                 |    |     |           |    |                 |
 * +--+--+--+--+--+--+    +--+--+--+--+--+--+    +--+--+--+--+--+--+
 * 
 * A hierarchical cubicle partition (HPC) is defined as follows. First,
 * we start with an initial rectangle of some given width w and height
 * h. The directive V s performs a vertical cut of size s, and the
 * directive H s performs a horizontal cut of size s. In either case,
 * this then followed by a sequence of directives for partitioning the
 * left (or lower) subrectangle and a sequence of directives for
 * partitioning the right (or upper) subrectangle. The directive . (a
 * period) stops the recursive cutting process and returns to the
 * previous level. Examples:
 *
 * V 2 . .                V 2 . H 3 . .       V 2 H 1 . . H 3 V 2 . . .
 * 
 * +--+--+--+--+--+--+    +--+--+--+--+--+--+    +--+--+--+--+--+--+
 * |     |           |    |     |           |    |     |           |
 * +  +  +  +  +  +  +    +  +  +--+--+--+--+    +  +  +--+--+--+--+
 * |     |           |    |     |           |    |     |     |     |
 * +  +  +  +  +  +  +    +  +  +  +  +  +  +    +  +  +  +  +  +  +
 * |     |           |    |     |           |    |     |     |     |
 * +  +  +  +  +  +  +    +  +  +  +  +  +  +    +--+--+  +  +  +  +
 * |     |           |    |     |           |    |     |     |     |
 * +--+--+--+--+--+--+    +--+--+--+--+--+--+    +--+--+--+--+--+--+
 *
 * An HCP defines a collection of rectangles, called cubicles. Given
 * an HCP list, this program outputs the collections of rectangles in
 * the partition, expressed as a 4-tuple x, y, w, h. If there is no 
 * cut, it simply outputs current rectangle. Otherwise, it computes
 * the two subrectangles resulting from the cut and then outputs
 * (recursively) the rectangles from left (lower) subrectangle
 * followed by the rectangles from the right (upper) subrectangle.
 *
 * This program is given the width and height of the entire office and
 * then a sequence of cutting directives. The program outputs an ASCII
 * drawing of the final HPC. 
 */

public class DrawCubicles_solution {

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

				checkValidity(w, h, hcpList); // check input validity

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
	private static void drawCubicles(int w, int h, ArrayList<String> hcpList) throws Exception
	{
		Iterator<String> hcpIterator = hcpList.iterator(); // iterator for the HCP list
		char drawing[][] = new char[2*w][2*h]; // 2D array to store the drawing

		for (int x = 0; x < w; x++) { // initialize the drawing
			for (int y = 0; y < h; y++) {
				drawing[2*x][2*y + 1] = ' '; drawing[2*x + 1][2*y + 1] = ' '; 
				drawing[2*x][2*y]     = '+'; drawing[2*x + 1][2*y]     = ' ';
				if (x == 0) drawing[0][2*y + 1] = '|';
				if (y == 0) drawing[2*x + 1][0] = '-';
			}
		}
		recDrawCubicles(0, 0, w, h, hcpIterator, drawing); // draw recursively
		printDrawing(drawing); // print the final drawing
	}

	/**
	 * Recursive helper for drawing the cubicles. Maps the directives list to
	 * drawing stored in the drawing array. We do no error checking.
	 */
	private static void recDrawCubicles(int x0, int y0, int w, int h, Iterator<String> hcpIterator, char[][] drawing) throws Exception {
		String token = hcpIterator.next();
		if (token.equals(".")) { // bottom level - return to calling program
			return;
		} else if (token.equalsIgnoreCase("V") || token.equalsIgnoreCase("H")) { // cut
			String sizeStr = hcpIterator.next(); // get size
			int size = Integer.valueOf(sizeStr); // convert to integer
			if (token.equalsIgnoreCase("V")) { // process vertical cut
				if (size < 1 || size >= w) {
					throw new Exception("cut size is out of bounds");
				}
				for (int y = 0; y < h; y++) { // draw the cutting line
					drawing[2 * (x0 + size)][2 * (y0 + y) + 1] = '|';
				}
				recDrawCubicles(x0, y0, size, h, hcpIterator, drawing); // draw left side
				recDrawCubicles(x0 + size, y0, w - size, h, hcpIterator, drawing); // draw right side
			} else { // process horizontal cut
				if (size < 1 || size >= h) {
					throw new Exception("cut size is out of bounds");
				}
				for (int x = 0; x < w; x++) { // draw the cutting line
					drawing[2 * (x0 + x) + 1][2 * (y0 + size)] = '-';
				}
				recDrawCubicles(x0, y0, w, size, hcpIterator, drawing); // draw lower side
				recDrawCubicles(x0, y0 + size, w, h - size, hcpIterator, drawing); // draw upper side
			}
		} else {
			throw new Exception("Expecting cut");
		}
		return;
	}

	/**
	 * Print the drawing. The top and right edges are added not stored in drawing
	 * but are added here.
	 */
	private static void printDrawing(char[][] drawing) {
		for (int x = 0; x < drawing.length / 2; x++) { // print the top row
			System.out.print("+--");
		}
		System.out.println("+");

		for (int y = drawing[0].length - 1; y >= 0; y--) { // print the other rows
			for (int x = 0; x < drawing.length; x++) {
				String entry = String.valueOf(drawing[x][y]); // entry to draw as string
				if (x % 2 == 0) {
					System.out.print(entry);  // on even columns print the entry
				} else {
					System.out.print(entry + entry); // on odd columns double it
				}
			}
			if (y % 2 == 0) { // finally, print the right edge
				System.out.println("+");
			} else {
				System.out.println("|");
			}
		}
	}

	/**
	 * Checks input for validity. This does not check that all the cuts are valid,
	 * merely that the string is well formed.
	 */
	private static void checkValidity(int w, int h, ArrayList<String> hcpList) throws Exception {
		if (w <= 0 || h <= 0) {
			throw new Exception("width and height must be strictly positive");
		}
		Iterator<String> hcpIterator = hcpList.iterator(); // get an iterator for the HCP list
		recCheckValidity(w, h, hcpIterator, ""); // check the HCP list recursively
		if (hcpIterator.hasNext()) { // not expecting any more tokens
			throw new Exception("Extra characters beyond the natural end of the HCP list");
		}
	}

	/**
	 * Recursively parses and checks the validity of the HCP list. Checks the
	 * validity of the HCP list syntax, and checks that cuts produce rectangles of
	 * positive width and height.
	 */

	private static void recCheckValidity(int w, int h, Iterator<String> hcpIterator, String prefix) throws Exception {
		if (w <= 0 || h <= 0) {
			throw new Exception("Width or height is invalid");
		}
		if (hcpIterator.hasNext()) {
			String token = hcpIterator.next();
			if (token.equals(".")) {
				// System.out.println(prefix + "[end]");
				return;
			} else if (token.equalsIgnoreCase("V") || token.equalsIgnoreCase("H")) {
				// System.out.print(prefix + token);
				if (hcpIterator.hasNext()) {
					String sizeStr = hcpIterator.next(); // get size
					// System.out.println(" " + sizeStr);
					try {
						int size = Integer.valueOf(sizeStr); // convert to integer
						if (size <= 0) {
							throw new Exception("Expecting positive number following 'V' or 'H' in HCP list");
						}
						if (token.equalsIgnoreCase("V")) { // process vertical cut
							recCheckValidity(size, h, hcpIterator, prefix + "- "); // check left side
							recCheckValidity(w - size, h, hcpIterator, prefix + "+ "); // check right side
						} else { // process horizontal cut
							recCheckValidity(w, size, hcpIterator, prefix + "- "); // check lower side
							recCheckValidity(w, h - size, hcpIterator, prefix + "+ "); // check upper side
						}
					} catch (NumberFormatException e) {
						throw new NumberFormatException("Expecting a number after 'V' or 'H' in HCP list");
					}
				} else {
					throw new Exception("Expecting something after 'V' or 'H' in HCP list");
				}
			} else {
				throw new Exception("Expecting either '.', 'V', or 'H' in HCP list");
			}
		} else {
			throw new Exception("HCP list ended abruptly");
		}
		return;
	}
}

