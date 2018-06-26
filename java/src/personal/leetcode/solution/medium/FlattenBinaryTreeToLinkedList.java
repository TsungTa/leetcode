package personal.leetcode.solution.medium;

/**
 * Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 
 * The flattened tree should look like:
 * 
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {
	
	public void flatten(TreeNode root) {
		flattenWithRecursion(root);
//		flattenWithNonRecursion(root);
    }
	
	private void flattenWithNonRecursion(TreeNode root) {
		while(root != null) {
			if(root.left != null) {
				TreeNode leaf = getRightLeaf(root.left);
				leaf.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
	
	private TreeNode getRightLeaf(TreeNode node) {
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	private TreeNode flattenWithRecursion(TreeNode root) {
		if(root == null) return null;
        
        TreeNode leftLeaf = flattenWithRecursion(root.left);
        TreeNode rightLeaf = flattenWithRecursion(root.right);
        
        if(root.left != null) {
        	TreeNode tmp = root.right;
        	root.right = root.left;
        	root.left = null;
        	
        	leftLeaf.right = tmp;
        }
        
        if(rightLeaf != null) return rightLeaf;
        if(leftLeaf != null) return leftLeaf;
        return root;
	}
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
