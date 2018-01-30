package personal.leetcode.solution;

import java.util.Arrays;

/*
 * From: https://leetcode.com/problems/array-partition-i/description/
 * 
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * 
 * Example 1:
 * 
 * 		Input: [1,4,3,2]
 * 		Output: 4
 * 
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * 
 * Note:
 * 		n is a positive integer, which is in the range of [1, 10000].
 * 		All the integers in the array will be in the range of [-10000, 10000].
 */

public class ArrayPartitionI {
	public int arrayPairSum(int[] nums) {
        //bubbleSort(nums);
        Arrays.sort(nums);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i+1]);
        }
        return sum;
    }
    
    // Bubble sort is too slow to pass the test case.
    private static void bubbleSort(int[] nums) {
        boolean done = false;
        for(int i = 0; i < nums.length - 1 && !done; i++) {
            done = true;
            for(int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    
                    done = false;
                }
            }
        }
    }
}
