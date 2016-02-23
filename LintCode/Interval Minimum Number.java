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
    
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public int start;
    public int end;
    public int min;
    public SegmentTreeNode (int start, int end, int min) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
        this.min = min;
    }
    
}
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        SegmentTreeNode root = buildTree(A, 0, A.length - 1);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Interval i : queries) {
            result.add(queryMinValue(root, i.start, i.end));
        }
        return result;
    }
    private SegmentTreeNode buildTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MAX_VALUE);
        
        if (start != end) {
            int mid = start + (end - start) / 2;
            root.left = buildTree(A, start, mid);
            root.right = buildTree(A, mid + 1, end);
            root.min = Math.min(root.left.min, root.right.min);
        } else {
            root.min = Math.min(A[start], root.min);
        }
        return root;
    }
    
    private int queryMinValue(SegmentTreeNode root, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == root.start && end == root.end) {
            return root.min;
        }
        int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
        //避免溢出
        int mid = root.start + (root.end - root.start) / 2;
        if (start <= mid) {
            if (mid < end) {
                leftMin = queryMinValue(root.left, start, mid);
            } else {
                leftMin = queryMinValue(root.left, start, end);
            }
        }
        if (end > mid) {
            if (mid < start) {
                rightMin = queryMinValue(root.right, start, end);
            } else {
                rightMin = queryMinValue(root.right, mid + 1, end);
            }
        }
        return Math.min(leftMin, rightMin);
    }
}