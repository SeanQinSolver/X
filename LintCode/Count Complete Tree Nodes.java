/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getLeft(root);
        int right = getRight(root);
        //System.out.println(left + "  " + right);
        
        if (left == right) return (1 << (left)) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int getLeft(TreeNode root) {
        int count = 1;
        while (root.left != null) {
            root = root.left;
            count++;
        }
        return count;
    }
    private int getRight(TreeNode root) {
        int count = 1;
        while (root.right != null) {
            root = root.right;
            count++;
        }
        return count;
    }
}