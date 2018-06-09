package personal.leetcode.solution.medium;

/**
 * link: https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Example:
 * 		Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Note:
 * 		Your algorithm should use only constant extra space.
 * 		You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

public class SwapNodesInPairs {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode swapPairs(ListNode head) {
        ListNode newHead = head;
        if(head != null && head.next != null) {
            newHead = head.next;
        }
        
        ListNode subGroupHead = new ListNode(0);
        subGroupHead.next = head;
        
        ListNode subGroupTail = null;
        
        while(subGroupHead != null && subGroupHead.next != null && subGroupHead.next.next != null) {
            subGroupTail = subGroupHead.next.next.next;
            swap(subGroupHead, subGroupTail);
            subGroupHead = subGroupHead.next.next;
        }
        
        return newHead;
    }
    
    private void swap(ListNode head, ListNode tail) {
        ListNode tmp = head.next.next;
        tmp.next = head.next;
        head.next.next = tail;
        head.next = tmp;
    }
}
