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
       if (A == null || A.length == 0) {
           return null;
       }
       return helperBuilder(A, 0, A.length - 1);
    }
    private TreeNode helperBuilder(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        
        TreeNode node = new TreeNode(num[(start + end) / 2]);
        node.left = helperBuilder(num, start, (start + end) / 2 - 1);
        node.right = helperBuilder(num, (start + end) / 2 + 1, end);
        return node;
    }
    
}
