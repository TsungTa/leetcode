package personal.leetcode.solution.medium;

/**
 * link: https://leetcode.com/problems/add-two-numbers/description/
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example
 * 		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 		Output: 7 -> 0 -> 8
 * 		Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode currentNode = ans;
        int carry = 0;
        boolean hasNext = false;
        int val1 = 0;
        int val2 = 0;
        
        do {
            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            
            carry = val1 + val2 + carry;
            currentNode.val = carry % 10;
            carry = carry / 10;
            
            hasNext = carry != 0 || l1 != null || l2 != null;
            if(hasNext){ 
                currentNode.next = new ListNode(0);
                currentNode = currentNode.next;
            }
            
            val1 = 0;
            val2 = 0;
        } while(hasNext);
        
        return ans;
    }
}
