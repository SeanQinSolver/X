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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length == 0) return null;
        return helper(A, 0, A.length - 1);
    }
    private TreeNode helper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode newNode = new TreeNode(A[mid]);
        newNode.left = helper(A, start, mid - 1);
        newNode.right = helper(A, mid + 1, end);
        return newNode;
    }
}
