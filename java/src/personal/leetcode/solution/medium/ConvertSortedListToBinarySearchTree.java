package personal.leetcode.solution.medium;

/**
 * Link: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * Example:
 * 		Given the sorted linked list: [-10,-3,0,5,9],
 * 		One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * 
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */

public class ConvertSortedListToBinarySearchTree {
	ListNode mHead = null;
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
		
		mHead = head;
		
		int count = 0;
		while(head != null) {
			head = head.next;
			count++;
		}
		
		return buildBST(count);
	}
	
	private TreeNode buildBST(int count) {
		if(count <= 0) return null;
		
		// create left tree
		TreeNode left = buildBST((count)/2);
		
		// create root
		TreeNode root = new TreeNode(mHead.val);
		root.left = left;
		mHead = mHead.next;
		
		// create right tree
		TreeNode right = buildBST(count - (count/2) - 1);
		root.right = right;
		
		return root;
	}
	
	// recursive, time complexity: O(nlogn)
	public TreeNode sortedListToBSTByRecursive(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return new TreeNode(head.val);
        else if(head.next.next == null) {
        	TreeNode bst = new TreeNode(head.val);
        	bst.right = new TreeNode(head.next.val);
        	return bst;
        }
        
        // To divide list into into three parts(root node, left tree nodes and right nodes)
        ListNode slow = head, fast = head, root = null, right = null, prev = null;
        while(fast.next != null && fast.next.next != null) {
        	prev = slow;
        	fast = fast.next.next;
        	slow = slow.next;
        }
        root = slow;
        right = slow.next;
        prev.next = null;
        root.next = null;
        
        // To merge root, right tree and left tree.
        TreeNode bst = new TreeNode(root.val);
        bst.left = sortedListToBST(head);
        bst.right = sortedListToBST(right);
        
        return bst;
	}
}
