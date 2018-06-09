package personal.leetcode.solution.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * link: https://leetcode.com/problems/single-number-iii/description/
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 
 * For example:
 * 		Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note:
 * 		The order of the result is not important. So in the above example, [5, 3] is also correct.
 * 		Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
        return singleNumberWithXOR(nums);
    }
	
	public int[] singleNumberWithXOR(int[] nums) {
        int xorResult = 0;
        for(int num : nums) {
        	xorResult ^= num;
        }
        
        int differentBit = xorResult & -xorResult;
        
        int[] res = new int[2];
        for(int num : nums) {
        	if((differentBit & num) == 0) res[0] ^= num;
        	else res[1] ^= num;
        }
        
        return res;
    }
	
	private int[] singleNumberWithSat(int[] nums) {
		int[] res = new int[2];
        HashSet<Integer> set = new HashSet();
        
        for(int i = 0; i < nums.length; i++) {
        	if(set.contains(nums[i])) set.remove(nums[i]);
        	else set.add(nums[i]);
        }
        
        if(set.size() != 2) {
        	throw new RuntimeException("invalid input");
        }
        
        Iterator<Integer> iterator = set.iterator();
        res[0] = iterator.next();
        res[1] = iterator.next();
        
        return res;
	}
}
