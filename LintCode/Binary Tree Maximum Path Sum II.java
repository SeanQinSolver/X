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
public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) return 0;
        int leftSum = maxPathSum2(root.left);
        int rightSum = maxPathSum2(root.right);
        return Math.max(0, Math.max(leftSum, rightSum)) + root.val;
    }
}


//此题的corner case是都是负数的话需要先将left, right与0比较，若小于0,则都不选。只选root。