package personal.leetcode.solution.easy;

import java.util.Stack;

/*
 * link: https://leetcode.com/problems/invert-binary-tree/description/
 * 
 * Invert a binary tree.
 * 		     4
 * 		   /   \
 * 		  2     7
 * 		 / \   / \
 * 		1   3 6   9
 * 	to
 *  	     4
 * 		   /   \
 * 		  7     2
 * 		 / \   / \
 * 		9   6 3   1
 */

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
		return invertTreeR(root);
    }
	
	// Recursion
	private TreeNode invertTreeR(TreeNode root) {
		if(root == null) return root;
		
		invertChildren(root);
		
		return root;
	}
	
	private void invertChildren(TreeNode node) {
		if(node == null) return;
		
		TreeNode tmpNode = node.left;
		node.left = node.right;
		node.right = tmpNode;
		
		invertChildren(node.left);
		invertChildren(node.right);
	}
	
	// Iterative
	private TreeNode invertTreeI(TreeNode root) {
		if(root == null) return root;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			
			TreeNode tmpNode = node.left;
			node.left = node.right;
			node.right = tmpNode;
			
			if(node.left != null) stack.push(node.left);
			if(node.right != null) stack.push(node.right);
		}
		
		return root;
	}
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
