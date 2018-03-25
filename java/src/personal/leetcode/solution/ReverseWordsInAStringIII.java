package personal.leetcode.solution;

/*
 * link: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 * 
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 		Input: "Let's take LeetCode contest"
 * 		Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        return reverse(s);
    }
    
    private static String reverse(String s) {
        StringBuilder ans = new StringBuilder();
        
        StringBuilder reverseWord = new StringBuilder();
        
        // it is better to convert into char array than use String.charAt()
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] != ' ') reverseWord.insert(0, charArray[i]);
            else {
                ans.append(reverseWord);
                ans.append(" ");
                reverseWord.setLength(0);
            }
        }
        
        ans.append(reverseWord);
        
        return ans.toString();
    }
    
    // without String.split() and StringBuilder
    private static String reverse3(String s) {
        String ans = "";
        
        String reverseWord = "";
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] != ' ') reverseWord = charArray[i] + reverseWord;
            if(charArray[i] == ' ' || i == (charArray.length - 1)) {
                if(!ans.isEmpty()) ans += " ";
                ans += reverseWord;
                reverseWord = "";
            }
        }
        
        return ans;
    }
    
    // with String.split()
    // without StringBuilder
    private static String reverse2(String s) {
        String ans = "";
        
        String[] words = s.split(" ");
        for(int i = 0; i < words.length; i++) {
            if(!ans.isEmpty()) ans += " ";
            ans += reverseOneWord(words[i]);
        }
        
        return ans;
    }
    
    private static String reverseOneWord(String s) {
        String result = null;
        
        char[] charArray = s.toCharArray();
        for(int i = 0; i < (charArray.length / 2); i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }
        
        return String.valueOf(charArray);
    }
    
    private static String reverseWordsByJavaAPI(String s) {
        String ans = "";
        
        String[] words = s.split(" ");
        for(int i = 0; i < words.length; i++) {
            if(!ans.isEmpty()) ans += " ";
            ans += new StringBuilder(words[i]).reverse().toString();
        }
        
        return ans;
    }
}
