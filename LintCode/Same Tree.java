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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (p.val != q.val) return false;
            boolean case1 = isSameTree(p.left, q.left);
            boolean case2 = isSameTree(p.right, q.right);
            return case1 && case2;
        } else {
            //[]与[0]的情况要排除
            return false;
        }
    }
}