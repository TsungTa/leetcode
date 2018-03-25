package personal.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*
 * link: https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * 		Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note:
 * 		Each element in the result must be unique.
 * 		The result can be in any order.
 */
public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null) return new int[0];
		
        HashSet<Integer> setOfNums1 = new HashSet<>();
        for(int num : nums1) {
        	setOfNums1.add(num);
        }
        
        HashSet<Integer> resultSet = new HashSet<>();
        for(int num : nums2) {
        	if(setOfNums1.contains(num)) resultSet.add(num);
        }
        
        int[] resultArray = new int[resultSet.size()];
        Iterator<Integer> iterator = resultSet.iterator();
        for(int i = 0; i < resultSet.size() && iterator.hasNext(); i++) {
        	resultArray[i] = iterator.next();
        }
        
        return resultArray;
    }
}
