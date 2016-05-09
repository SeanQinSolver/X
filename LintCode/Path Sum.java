/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//写法一
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hashPath(root, sum, 0);
    }
    
    private boolean hashPath(TreeNode root, int target, int sum) {
        if (sum + root.val == target && root.left == null && root.right == null) {
            return true;
        }
        boolean case1 = false;
        boolean case2 = false;
        if (root.left != null){
            case1 = hashPath(root.left, target, sum + root.val);
        }
        if (root.right != null) {
            case2 = hashPath(root.right, target, sum + root.val);
        }
        return case1 || case2;
    }
}

//写法2

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null && root.val - sum == 0) return true;
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}