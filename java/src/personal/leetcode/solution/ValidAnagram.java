package personal.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;

/*
 * link: https://leetcode.com/problems/valid-anagram/description/
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * 		s = "anagram", t = "nagaram", return true.
 * 		s = "rat", t = "car", return false.
 * 
 * Note:
 * 		You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * 		What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(sort(s).equals(sort(t))) return true;
        else return false;
	}
    
    private String sort(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
