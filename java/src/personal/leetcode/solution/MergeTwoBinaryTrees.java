package personal.leetcode.solution;

/*
 * From: https://leetcode.com/problems/merge-two-binary-trees/description/
 * 
 * Given two binary trees and imagine that when you put one of them to cover the other, 
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. 
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. 
 * Otherwise, the NOT null node will be used as the node of new tree.
	
 * Example 1:
 * 
 * Input: 
 * 		Tree 1                     Tree 2                  
 *       	    1                         2                             
 *      	    / \                       / \                            
 *      	   3   2                     1   3                        
 *      	  /                           \   \                      
 *      	 5                             4   7                  
 * 
 * Output: 
 * 		Merged tree:
 * 		     3
 * 		    / \
 * 	 	   4   5
 * 		  / \   \ 
 * 		 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 */

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return mergeTreesR(t1, t2);
    }
    
    // recursion
    private TreeNode mergeTreesR(TreeNode t1, TreeNode t2) {
        if(t1 != null && t2 != null) {
            TreeNode node = new TreeNode(t1.val + t2.val);
            node.left = mergeTreesR(t1.left, t2.left);
            node.right = mergeTreesR(t1.right, t2.right);
            return node;
        } else if(t1 != null && t2 == null) return t1;
        else if(t1 == null && t2 != null) return t2;
        else return null;
    }
    
    // iterative
    private TreeNode mergeTreesI(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        
        // merge root
        TreeNode result = new TreeNode(t1.val + t2.val);
        
        java.util.Stack<Nodes> stack = new java.util.Stack<Nodes>();
        stack.push(new Nodes(result, t1, t2));
        
        // merge children
        do {
            Nodes nodes = stack.pop();
            
            // merge right child
            if(nodes.t1.right != null && nodes.t2.right != null) {
                nodes.result.right = new TreeNode(nodes.t1.right.val + nodes.t2.right.val);
                stack.push(new Nodes(nodes.result.right, nodes.t1.right, nodes.t2.right));
            } else if(nodes.t1.right != null && nodes.t2.right == null) {
                nodes.result.right = nodes.t1.right;
            } else if(nodes.t1.right == null && nodes.t2.right != null)  {
                nodes.result.right = nodes.t2.right;
            } else {
                nodes.result.right = null;
            }
            
            // merge left child
            if(nodes.t1.left != null && nodes.t2.left != null) {
                nodes.result.left = new TreeNode(nodes.t1.left.val + nodes.t2.left.val);
                stack.push(new Nodes(nodes.result.left, nodes.t1.left, nodes.t2.left));
            } else if(nodes.t1.left != null && nodes.t2.left == null) {
                nodes.result.left = nodes.t1.left;
            } else if(nodes.t1.left == null && nodes.t2.left != null)  {
                nodes.result.left = nodes.t2.left;
            } else {
                nodes.result.left = null;
            }
        } while(!stack.empty());
        
        return result;
    }
    
    class Nodes {
        public TreeNode result;
        public TreeNode t1;
        public TreeNode t2;
        
        public Nodes(TreeNode result, TreeNode t1, TreeNode t2) {
            this.result = result;
            this.t1 = t1;
            this.t2 = t2;
        }
    }
}
