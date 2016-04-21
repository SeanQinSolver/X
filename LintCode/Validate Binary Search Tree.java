/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class ResultType {
    boolean is_bst;
    int maxValue, minValue;
    
    ResultType(boolean is_bst, int maxValue, int minValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
    
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long lower, long higher) {
        if (root == null)  {
            return true;
        }
        if (root.val >= higher | root.val <= lower) return false;
        boolean isValidLeft = helper(root.left, lower, root.val);
        boolean isValidRight = helper(root.right, root.val, higher);
        
        return isValidLeft && isValidRight;
    }
}
