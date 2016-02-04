/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        return helper(0, A.length - 1, A);
    }
    private SegmentTreeNode helper(int start, int end, int[] array) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
        if (start != end) {
            int mid = (start + end) / 2;
            root.left = helper(start, mid, array);
            root.right = helper(mid + 1, end, array);
            
            root.max = Math.max(root.left.max, root.right.max);
        } else {
            root.max = array[end];
        }
        return root;
    }
}