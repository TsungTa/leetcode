package personal.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

/*
 * link: https://leetcode.com/problems/keyboard-row/description/
 * 
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * 
 * Example 1:
 * 		Input: ["Hello", "Alaska", "Dad", "Peace"]
 * 		Output: ["Alaska", "Dad"]
 * 
 * Note:
 * 		You may use one character in the keyboard more than once.
 * 		You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow {
	private static final String FIRST_ROW = "qwertyuiop";
	private static final String SECOND_ROW = "asdfghjkl";
	private static final String THIRD_ROW = "zxcvbnm";
	
	private static final String KEYBOARD_ROW_RE = "^[qwertyuiop]+$|^[asdfghjkl]+$|^[zxcvbnm]+$";
	private static Pattern pattern = Pattern.compile(KEYBOARD_ROW_RE);
	
	public String[] findWords(String[] words) {
		return findWordsWithCharComparing(words);
	}
	
    public String[] findWordsWithCharComparing(String[] words) {
        if(words == null) return null;
        
        ArrayList<String> result = new ArrayList<>();
        for(String word : words) {
        	int row = 0;
        	for(char c : word.toLowerCase().toCharArray()) {
        		if(FIRST_ROW.indexOf(c) != -1) {
        			if(row != 0 && row != 1) { row = -1; break;} 
        			row = 1;
        		} else if(SECOND_ROW.indexOf(c) != -1) {
        			if(row != 0 && row != 2) { row = -1; break;} 
        			row = 2;
        		} else {
        			if(row != 0 && row != 3) { row = -1; break;}
        			row = 3;
        		}
        	}
        	if(row > 0) result.add(word);
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    public String[] findWordsWithRegularExpression(String[] words) {
		ArrayList<String> list = new ArrayList<>();
		for(String word : words) {
			if(pattern.matcher(word.toLowerCase()).find()) list.add(word);
		}
		return list.toArray(new String[list.size()]);
	}
}
