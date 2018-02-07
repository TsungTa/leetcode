package personal.leetcode.solution;

import java.util.Stack;

/*
 * link: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * 
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * For example:
 * 		Given binary tree [3,9,20,null,null,15,7],
 * 
 * 		    3
 * 		   / \
 * 		  9  20
 * 		    /  \
 * 		   15   7
 * 	
 * 		return its depth = 3.
 */
public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        return maxDepthR(root);
    }
	
	// recursion
	private int maxDepthR(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max(maxDepthR(root.left), maxDepthR(root.right));
	}
	
	// iterative
	private int maxDepthI(TreeNode root) {
		if(root == null) return 0;
		
		int depth = 0;
		Stack<Node> nodeStack = new Stack<>();
		nodeStack.push(new Node(root, 1));
		
		while(!nodeStack.isEmpty()) {
			Node currentNode = nodeStack.pop();
			
			if(currentNode.node.right != null) nodeStack.push(new Node(currentNode.node.right, currentNode.depth + 1));
			if(currentNode.node.left != null) nodeStack.push(new Node(currentNode.node.left, currentNode.depth + 1));
			
			depth = Math.max(depth, currentNode.depth);
		}
		
		return depth;
	}
	
	class Node {
		int depth;
		TreeNode node;
		Node(TreeNode node, int depth) { 
			this.node = node;
			this.depth = depth;
		}
	}

	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
