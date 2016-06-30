public class Solution {
    /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is
     *          smaller than it and return count number array
     */
    SegmentTreeNode root;
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        //先build 0 到 10000的segment tree
        root = buildTree(0, 10000);
        ArrayList<Integer> rst = new ArrayList<Integer>();
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = 0;
            if (A[i] > 0) {
                //temp代表小于A[i]并在其之前的次数，相当于0->A[i]-1之间的count
                //刚开始的时候比如[1, 2, 7, 8, 5]没有第一位1之前没有任何小于他的数，然后count为0.考虑了他以后更新A[i]上面的count即将值为A[i]的count加上1
                temp = querySegmentTreeNode(root, 0, A[i] - 1);
            }
            //更新count加上1
            modifySegmentTree(root, A[i], 1);
            rst.add(temp);
        }
        return rst;
    }
    //先Build一个tree，上面所有的 count为0
    private SegmentTreeNode buildTree(int start, int end) {
        if (start > end) return null;
        if (start == end) {
            SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
            return root;
        }
        
        int mid = start + (end - start) / 2;
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        root.left = buildTree(start, mid);
        root.right = buildTree(mid + 1, end);
        return root;
    }
    //query tree for count
    private int querySegmentTreeNode(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.count;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        int leftCount = 0;
        int rightCount = 0;
        
        if (start <= mid) {
            if (mid < end) {
                leftCount = querySegmentTreeNode(root.left, start, mid);
            } else {
                leftCount = querySegmentTreeNode(root.left, start, end);
            }
        }
        
        if (mid < end) {
            if (start <= mid) {
                rightCount = querySegmentTreeNode(root.right, mid + 1, end);
            } else {
                rightCount = querySegmentTreeNode(root.right, start, end);
            }
        }
        return leftCount + rightCount;
    }
    //修改root.start / end == index的count + value.
    private void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.count = root.count + value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index <= mid && root.start <= index) {
            modifySegmentTree(root.left, index, value);
        }
        if (index <= root.end && mid < index) {
            modifySegmentTree(root.right, index, value);
        }
        root.count = root.left.count + root.right.count;
    }
    
    
    private static class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
}
