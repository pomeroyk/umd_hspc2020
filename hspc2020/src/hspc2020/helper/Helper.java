package hspc2020.helper;

import java.util.Random;

public class Helper {

	public static void generateArray(int lower, 
			int upper, 
			int length, 
			boolean printRowLengthFirst,
			boolean onlyEvens) {
		
		assert lower >= 0;
		assert upper > lower;
		assert length > 0;
		
		if(printRowLengthFirst) {
			System.out.print(length + " ");
		}
		
		Random r = new Random();
		for(int i=0; i<length; i++) {
			int num = lower + r.nextInt(upper-lower+1);
			if(onlyEvens) {
				while(num % 2 != 0) {
					num = lower + r.nextInt(upper-lower+1);
				}
			}
			System.out.print(num + " ");
		}
	}
	
	public static void generateArray(int lower, int upper, int length) {
		generateArray(lower, upper, length, false, false);
	}
	
	// Generates an n x m array of nonnegative ints between lower and upper
	// Prints:
	// n m
	// row 1 ...
	// row 2 ...
	public static void generateMatrix(int n, int m, int lower, int upper) {
		assert lower >= 0;
		assert upper > lower;
		assert n > 0;
		assert m > 0;
		
		System.out.println(n + " " + m);
		for(int i=0; i<n; i++) {
			generateArray(lower, upper, m);
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		boolean printRowLengthFirst = true;
		boolean onlyEvens = false;
		for(int i=0; i<25; i++) {
			//generateMatrix(200, 20, 0, 1000);
			generateArray(0, 5, 100, printRowLengthFirst, onlyEvens);
			System.out.println();
		}
	}
	
	
}
