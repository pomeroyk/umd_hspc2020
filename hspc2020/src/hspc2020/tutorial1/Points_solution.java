package hspc2020.tutorial1;

import java.util.Scanner;
import java.util.Stack;

public class Points_solution {

	private static int countPoints(int len, String[] ops) {
		//YOUR CODE HERE
	    Stack<Integer> stack = new Stack<Integer>();

	    for(String op : ops) {
	        if(op.equals("+")) {   // Add the last two valid rounds' points
	            int top = stack.pop();
	            int newTop = top + stack.peek();
	            stack.push(top);
	            stack.push(newTop);
	        } else if(op.equals("R")) {   // Reject the last valid round
	            stack.pop();
	        } else if(op.equals("D")) {   // Double the last valid round
	            stack.push(2 * stack.peek());
	        } else {
	            stack.push(Integer.valueOf(op));
	        }
	    }

	    int totalPoints = 0;
	    for(int score : stack) { 
	    	totalPoints += score; 
	    }
	    return totalPoints;
		//YOUR CODE HERE
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		sc.nextLine();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 

			int len = sc.nextInt();
			assert len > 0 : "Illegal length";

			String[] ops = new String[len];
			for (int idx=0; idx<len; idx++) {
				ops[idx] = sc.next();
			}
			sc.nextLine();

			System.out.println(
					countPoints(len, ops)
					);
		}

		sc.close();
	}
}