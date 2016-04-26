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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    private int findPos(int[] inorder, int start, int end, int key) {
        // if (inorder[start] == key) return start;
        // if (inorder[end] == key) return end;
        // while (start + 1 < end) {
        //     int mid = start + (end - start) / 2;
        //     if (inorder[mid] == key) {
        //         return mid;
        //     } else if (inorder[mid] < key) {
        //         start = mid;
        //     } else {
        //         end = mid;
        //     }
        // }
        // if (inorder[start] == key) {
        //     return start;
        // } else {
        //     return end;
        // }
        //不能用binary search,因为不是bst
        int i;
        for (i = start; i <= end; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    private TreeNode build(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend) {
        if (instart > inend || prestart > preend) return null;
        
        int pos = findPos(inorder, instart, inend, preorder[prestart]);
        //System.out.println(pos + "   " + preorder[prestart]);
        TreeNode root = new TreeNode(preorder[prestart]);
        
        int dist = pos - instart;
        
        root.left = build(inorder, instart, pos - 1, preorder, prestart + 1, prestart + dist);
        root.right = build(inorder, pos + 1, inend, preorder, prestart + dist + 1, preend);
        
        return root;
    }
    
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder.length != inorder.length) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
}
