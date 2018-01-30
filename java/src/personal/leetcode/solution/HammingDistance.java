package personal.leetcode.solution;

/*
 * Form: https://leetcode.com/problems/hamming-distance/description/
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note: 0 < x, y < 2^31.
 * 
 * Example:
 * 
 * 		Input: x = 1, y = 4
 * 		Output: 2
 * 	
 * Explanation:
 * 		1   (0 0 0 1)
 * 		4   (0 1 0 0)
 * 		       ↑   ↑
 * 	
 * 	The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {

	public int hammingDistance(int x, int y) {
        return bitCount(x^y);
    }
    
	/*
    public static int bitCount(int x) {
        return Integer.bitCount(x);
    }
    */
    
    public static int bitCount(int x) {
        int count = 0;
        while(x != 0) {
            if((x & 0b1) != 0) count++;
            x = x >>> 1;
        }
        
        return count;
    }
    
    /*
    // http://blog.csdn.net/brandohero/article/details/42656733
    public static int bitCount(int x) {
        int count = 0;
        
        while(x != 0) {
            count++;
            x = x & (x - 1);
        }
        
        return count;
    }
    */
    
    // from Integer.bitCount() for Java 1.5+
    /*
    public static int bitCount(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
    */
}
