package personal.leetcode.solution.medium;

/**
 * Link: https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 <= m <= n <= length of list.
 * 
 * Example:
 * 		Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * 		Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        
        // dummy -> ... -> prev -> ...reverse... -> end -> ... -> null
        ListNode dummy = new ListNode(0), prev = null, end = null, revertedHead = null, revertedTail = null;
        dummy.next = head;
        
        // search the list from dummy header
        head = dummy;
        
        boolean reverse = false;
        int count = 0;
        
        while(head != null) {
        	if(count == m - 1) {
        		// we found the node which before the reverted sub list.
        		prev = head;
        	} else if(count == m) {
        		// we found the tail node of reverted sub list.
        		revertedTail = head;
        		reverse = true;
        	} else if(count == n) {
        		end = head.next;
        	} else if(count == n + 1) {
        		// Stop. Don't have to trace the rest.
        		break;
        	}
        	
        	count++;
        	
        	if(reverse) {
        		ListNode tmp = head.next;
        		
        		head.next = revertedHead;
        		revertedHead = head;
        		
        		head = tmp;
        	} else {
        		head = head.next;
        	}
        }
        
        prev.next = revertedHead;
        revertedTail.next = end;
        
        return dummy.next;
    }
}
