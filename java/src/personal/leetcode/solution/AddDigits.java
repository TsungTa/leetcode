package personal.leetcode.solution;

import java.util.ArrayList;

/*
 * From: https://leetcode.com/problems/add-digits/description/
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * 		Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * 		Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
	public int addDigits(int num) {
		return addDigitsWithFormula(num);
    }
	
	private int addDigitsWithLoop(int num) {
		while(num >= 10) {
			num = sumI(num);
		}
		return num;
	}
	
	// recursion
	private int sumR(int num) {
		if(num < 10) return num;
		return (num % 10) + sumR(num / 10);
	}
	
	// iterative
	private int sumI(int num) {
		ArrayList<Integer> list = splitNumbers(num);
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum = sum + list.get(i);
		}
		return sum;
	}
	
	private ArrayList splitNumbers(int num) {
		ArrayList<Integer> list = new ArrayList<>();
		while(num >= 10) {
			list.add(num % 10);
			num = num / 10;
		}
		list.add(num);
		return list;
	}
	
	/*
	 * We can observe a pattern by following table.
	 * 
	 * ----------------------------------------------------------------------------------------------------------
	 * | Number | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 | 21 |
	 * ----------------------------------------------------------------------------------------------------------
	 * | Result | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9 |  1 |  2 |  3 | 
	 * ----------------------------------------------------------------------------------------------------------
	 * 
	 */
	private int addDigitsWithFormula(int num) {
		if(num == 0) return num;
		
		int result = num % 9;
		if(result == 0) result = 9;
		
		return result;
		
		// This can be simplified to a one-liner.
		// return (num - 1) % 9 + 1; 
	}
}
