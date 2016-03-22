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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        if (inorder.length == 0 || postorder.length == 0) return null;
        if (inorder.length != postorder.length) return null;
        
        TreeNode root = helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }
    private TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        
        //corner case
        if (instart > inend || poststart > postend)  return null;
    
        //build root TreeNode
        int root_val = postorder[postend];
        TreeNode root = new TreeNode(root_val);
        //find the root position in inorder list
        int position = findPost(inorder, instart, inend, root_val);
        //calculate the distance diff between position and instart, this difference will
        //offer to calculate the point in postorder.
        int dist = position - instart;
        //build the left tree
        root.left = helper(inorder, instart, position - 1, postorder, poststart, poststart + dist - 1);
        //build the right tree
        root.right = helper(inorder, position + 1, inend, postorder, poststart + dist, postend - 1);
        return root;
    }
    
    private int findPost(int[] num, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (num[i] == key) {
                return i;
            }
        }
        return -1;
    }
}