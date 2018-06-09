package personal.leetcode.solution.medium;

/**
 * link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * 
 * Example:
 * 		Given linked list: 1->2->3->4->5, and n = 2.
 * 		After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * 		Given n will always be valid.
 * 
 * Follow up:
 * 		Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
            
        ListNode frontNode = dummy;
        ListNode backNode = dummy;
        
        int index = 0;
        while(frontNode != null) {
            frontNode = frontNode.next;
            if(index > n) backNode = backNode.next;
            index++;
        }
        
        backNode.next = backNode.next.next;
        
        return dummy.next;
    }
}
