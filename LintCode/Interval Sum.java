/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class SegmentTreeNode {
    public int start;
    public int end;
    public Long sum;
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public SegmentTreeNode(int start, int end, Long sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = this.right = null;
    }
    
}
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */

    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        ArrayList<Long> result = new ArrayList<Long>();
        SegmentTreeNode root = buildTree(0, A.length - 1, A);
        for(Interval i : queries) {
            result.add(querySum(root, i.start, i.end));
        }
        return result;
    }
    
    public SegmentTreeNode buildTree(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        //注意initalize的0L
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0L);
        
        if (start != end) {
            int mid = start + (end - start) / 2;
            root.left = buildTree(start, mid, A);
            root.right = buildTree(mid + 1, end, A);
            root.sum = root.left.sum + root.right.sum;
        } else {
            root.sum = Long.valueOf(A[start]);
        }
        return root;
    }
    
    public Long querySum(SegmentTreeNode root, int start, int end) {
        if (start > end) {
            return 0L;
        }
        if (start == root.start && root.end == end) {
            return root.sum;
        }
        Long leftSum = 0L, rightSum = 0L;
        //注意此mid是root的start和end计算
        int mid = root.start + (root.end - root.start) / 2;
        
        if (start <= mid) {
            if (end > mid) {
                leftSum = querySum(root.left, start, mid);
            } else {
                leftSum = querySum(root.left, start, end);
            }
        }
        if (mid < end) {
            if (start > mid) {
                rightSum = querySum(root.right, start, end);
            } else {
                rightSum = querySum(root.right, mid + 1, end);
            }
        }
        return leftSum + rightSum;
    }
}
