package personal.leetcode.solution;

/*
 * link: https://leetcode.com/problems/implement-strstr/description/
 * 
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * 		Input: haystack = "hello", needle = "ll"
 * 		Output: 2
 * 
 * Example 2:
 * 		Input: haystack = "aaaaa", needle = "bba"
 * 		Output: -1
 */

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
        return strStrWithJavaAPI(haystack, needle);
        // return strStrNonJavaAPI(haystack, needle);
    }
    
    public int strStrNonJavaAPI(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return -1;
        }
        
        if(haystack.isEmpty() && needle.isEmpty()) {
            return 0;
        }
        
        for(int i = 0; i < haystack.length(); i++) {
            for(int j = 0; j <= needle.length(); j++) {
                if(j == needle.length()) {
                    return i;
                } else if((i + needle.length() -1) > haystack.length() -1) {
                    return -1;
                } else if(haystack.charAt(i + j) == needle.charAt(j)) {
                    continue;
                } else {
                    break;
                }
            }
        }
           
        return -1;
    }
    
    public int strStrWithJavaAPI(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
