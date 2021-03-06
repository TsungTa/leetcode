package personal.leetcode.solution.easy;

/*
 * link: https://leetcode.com/problems/excel-sheet-column-number/description/
 * 
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 */
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
        int number = 0;
        
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++ ) {
        	number = number * 26;
        	number = number + (charArray[i] - 'A' + 1);
        }
        
        return number;
    }
}
