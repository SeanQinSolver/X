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
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && end == root.end) {
            return root.max;
        }
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int mid = root.start + (root.end - root.start) / 2;
        //left
        if (start <= mid) {
            if (mid < end) {
                leftMax = query(root.left, start, mid);
            } else {
                leftMax = query(root.left, start, end);
            }
        }
        //right
        if (mid < end) {
            if (start > mid) {
                rightMax = query(root.right, start, end);
            } else {
                rightMax = query(root.right, mid + 1, end);
            }
        }
        return Math.max(leftMax, rightMax);
    }
}