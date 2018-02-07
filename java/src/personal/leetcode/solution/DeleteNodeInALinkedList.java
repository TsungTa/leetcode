package personal.leetcode.solution;

/*
 * link: https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
		if(node == null) return;
        
		// Key point:
		// 1. Because we don't have previous node to change the link which point to current node.
		//    Therefore, we copy next node to replace current node.
		// 2. When the loop proceed to second-last node, we remove the last node after copy it.
		while(node.next != null) {
        	node.val = node.next.val;
        	if(node.next.next == null) node.next = null; 
        	else node = node.next;
        }
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
