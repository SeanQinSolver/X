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
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        helperModi(root, index, value);
    }
    
    public int helperModi(SegmentTreeNode root, int index, int value) {
        if (index == root.start && index == root.end && root.start == root.end) {
            root.max = value;
            return root.max;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            root.left.max = helperModi(root.left, index, value);
        } else {
            root.right.max = helperModi(root.right, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
        return root.max;
    }
}