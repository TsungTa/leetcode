package personal.leetcode.solution.medium;

/**
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 		Input: 1->2->3->3->4->4->5
 * 		Output: 1->2->5
 * 
 * Example 2:
 * 		Input: 1->1->1->2->3
 * 		Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
        
		ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        
        while(prev.next != null && prev.next.next!= null) {
        	
        	if(prev.next.val == prev.next.next.val) {
        		// remove duplicate
        		prev.next = findNonDuplicateNode(prev.next);
        	} else {
        		prev = prev.next;
        	}
        }
        
        return dummy.next;
    }
	
	private ListNode findNonDuplicateNode(ListNode head) {
		int value = head.val;
		while(head != null && head.val == value) {
			head = head.next;
		}
		
		return head;
	}
}
