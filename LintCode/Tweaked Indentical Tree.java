/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.left = this.right = null;
 *     }
 * }
 */
 //有可能转的最后回到了本身的状态
public class Solution {
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        else if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        if (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)) {
            return true;
        }
        if (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)) {
            return true;
        }
        return false;
        
    }
}

//有可能转的最后回到了本身的状态,此题有可能转180度，有可能转360度回到原来