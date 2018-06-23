package personal.leetcode.solution.easy;

/**
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * Example 1:
 * 		Input: 1->1->2
 * 		Output: 1->2
 * 
 * Example 2:
 * 		Input: 1->1->2->3->3
 * 		Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		
		ListNode p = head;
        while(p.next != null) {
        	if(p.val != p.next.val) p = p.next;
        	else p.next = p.next.next;
        }
        
        return head;
    }
}
