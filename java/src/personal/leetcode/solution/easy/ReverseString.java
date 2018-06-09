package personal.leetcode.solution.easy;

/*
 * link: https://leetcode.com/problems/reverse-string/description/
 * 
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * Example:
 * 		Given s = "hello", return "olleh".
 */
public class ReverseString {
	public String reverseString(String s) {
		if(s == null) {
			return null;
		}
		
		StringBuilder result = new StringBuilder();
		
		for(int i = s.length() - 1; i >= 0; i--) {
			result.append(s.charAt(i));
		}
		
		return result.toString();
    }
	
	/*
	 * Using StringBuild.reverse() method.
	 */
	public String reverseStringUsingSBMethod(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}
