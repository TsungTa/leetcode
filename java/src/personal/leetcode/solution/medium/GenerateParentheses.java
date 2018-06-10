package personal.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * link: https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {
	private static final char LEFT_PARENTHESIS = '(';
	private static final char RIGHT_PARENTHESIS = ')';
	
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        
        StringBuilder baseParentheses = new StringBuilder();
        for(int i = 0; i < n - 1; i++) {
        	baseParentheses.insert(0, LEFT_PARENTHESIS);
        	baseParentheses.insert(baseParentheses.length(), RIGHT_PARENTHESIS);
        }
        
        res.add(baseParentheses.toString());
        
        for(int i = 1; i < baseParentheses.length() - 1; i++) {
        	if(baseParentheses.charAt(i) == baseParentheses.charAt(i + 1)) {
        		continue;
        	}
        	swap(baseParentheses, i, i + 1);
        	res.add(baseParentheses.toString());
        }
        
        return res;
    }
    
    private static void swap(StringBuilder sb, int index1, int index2) {
    	char c = sb.charAt(index2);
    	sb.setCharAt(index2, sb.charAt(index1));
    	sb.setCharAt(index1, c);
    }
}