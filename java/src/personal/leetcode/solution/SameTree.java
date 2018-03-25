package personal.leetcode.solution;

import java.util.Stack;

/*
 * link: https://leetcode.com/problems/same-tree/description/
 * 
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * 
 * Example 1:
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 * 
 *         [1,2,3],   [1,2,3]
 * 
 * Output: true
 * 
 * Example 2:
 * Input:     1         1
 *           /           \
 *          2             2
 * 
 *         [1,2],     [1,null,2]
 * 
 * Output: false
 * 
 * Example 3:
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 * 
 *         [1,2,1],   [1,1,2]
 * 
 * Output: false
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeR(p, q);
    }
	
	// Recursion
	private boolean isSameTreeR(TreeNode p, TreeNode q) {
		if(p == null && q == null) {
			return true;
		} 

		if(p != null && q != null && p.val == q.val) {
			return (isSameTreeR(p.left, q.left) && isSameTreeR(p.right, q.right));
		} else {
			return false;
		}
	}
	
	// Iterative
	private boolean isSameTreeI(TreeNode p, TreeNode q) {
		Stack<TreeNode> stackP = new Stack<>();
		stackP.push(p);
		Stack<TreeNode> stackQ = new Stack<>();
		stackQ.push(q);
		
		boolean isSameTree = true;
		while(!stackP.isEmpty() && !stackQ.isEmpty()) {
			TreeNode nodeP = stackP.pop();
			TreeNode nodeQ = stackQ.pop();
			
			if(nodeP == null && nodeQ == null) {
				continue;
			} else if(nodeP != null && nodeQ != null && nodeP.val == nodeQ.val) {
				stackP.push(nodeP.left);
				stackP.push(nodeP.right);
				
				stackQ.push(nodeQ.left);
				stackQ.push(nodeQ.right);
				
				continue;
			} else {
				isSameTree = false;
				break;
			}
		}
		
		return isSameTree;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
