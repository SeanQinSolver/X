/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
               // write your code here
        if (root == null || start > end) {
            return 0;
        }
        if (start <= root.start && end >= root.end) {
            return root.count;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int leftSum = 0;
        int rightSum = 0;
        //对称1
        if (start <= mid) {
            //对称2
            if (mid <= end) {
                leftCount = query(root.left, start, mid);
            } else {
                leftCount= query(root.left, start, end);
            }
        }
        //对称1
        if (mid <= end) {
            //对称2
            if (start <= mid) {
                rightCount = query(root.right, mid + 1, end);
            } else {
                rightCount = query(root.right, start, end);
            }
            
        }
        
        return leftSum + rightSum;
    }
}