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

//recursion

public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) return node;
        if (node == null) return root;
        
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}

//iteration
public class Solution {

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) return node;
        
        TreeNode rootCopy = root;
        while (root != null) {
            if (root.val <= node.val && root.right == null) {
                root.right = node;
                break;
            } else if (root.val > node.val && root.left == null) {
                root.left = node;
                break;
            }
            
            if (root.val <= node.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return rootCopy;
    }
}