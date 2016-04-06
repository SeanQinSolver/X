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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        String s = String.valueOf(root.val);
        helper(root, result, s);
        return result;
    }
    private void helper(TreeNode root, List<String> result, String s){
        if (root.left == null && root.right == null) {
            result.add(s);
        }
        if (root.left != null) {
            helper(root.left, result, s + "->" + root.left.val);
        }
        if (root.right != null) {
            helper(root.right, result, s + "->" + root.right.val);
        }
    }
}