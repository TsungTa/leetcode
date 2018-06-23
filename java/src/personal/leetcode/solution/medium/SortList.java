package personal.leetcode.solution.medium;

/**
 * Link: https://leetcode.com/problems/sort-list/description/
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 		Input: 4->2->1->3
 * 		Output: 1->2->3->4
 * 
 * Example 2:
 * 		Input: -1->5->3->4->0
 * 		Output: -1->0->3->4->5
 */
public class SortList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode sortList(ListNode head) {
		// Return if it is empty list or has only one node.
		if(head == null || head.next == null) return head;
        
		ListNode fast = head, slow = head, right = null;
		
		// To divide list into tow list.
		while(slow.next != null && slow.next.next != null) {
			fast = fast.next;
			slow = slow.next.next;
		}
		right = fast.next;
		fast.next = null;
		
		head = sortList(head);
		right = sortList(right);
		
		return merge(head, right);
    }
	
	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0), point = dummy;
		
		// To merge left list and right list
		while(left != null && right != null) {
			if(left.val < right.val) {
				point.next = left;
				left = left.next;
			} else {
				point.next = right;
				right = right.next;
			}
			point = point.next;
			point.next = null;
		}
		
		// To merge the rest of nodes.
		if(left != null) {
			point.next = left;
		} else if(right != null) {
			point.next = right;
		}
		
		return dummy.next;
	}
}
