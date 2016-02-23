public class Solution {
    /* you may need to use some attributes here */
    
    class SegmentTreeNode {
        public int start;
        public int end;
        public int sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }
    
    
    SegmentTreeNode root;
    
    public SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        
        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);
            root.sum = root.left.sum + root.right.sum;
        } else {
            root.sum = A[start];   
        }
        return root;
    }
    
     public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        
        //if reach the leaves that both left and right are equaled
        if (start == root.start && root.end == end) {
            return root.sum;
        }
        
        int leftSum = 0, rightSum = 0;
        int mid = root.start + (root.end - root.start) / 2;
        if (start <= mid) {
            if (mid < end) {
                leftSum = querySegmentTree(root.left, start, mid);
            } else {
                leftSum = querySegmentTree(root.left, start, end);
            }
        }
        
        if (mid < end) {
            if (start > mid) {
                rightSum = querySegmentTree(root.right, start, end);
            } else {
                rightSum = querySegmentTree(root.right, mid + 1, end);
            }
        }
        return leftSum + rightSum;
    }
    
    
    public void modifySegmentTreeNode(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (root.start <= index && index <= mid) {
            modifySegmentTreeNode(root.left, index, value);
        }
        if (index > mid && index <= root.end) {
            modifySegmentTreeNode(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
       root = build(0, A.length - 1, A);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return querySegmentTree(root, start, end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
       modifySegmentTreeNode(root, index, value);
    }
   
   
}
