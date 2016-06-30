public class Solution {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        
        int start, end, mid;
        int[] bound = new int[2];
        
        //search for left bound
        
        //search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        return bound;
    }
}

//写法2

public class Solution {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = A.length - 1;
        int leftIndex = 0;
        //left bound
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] == target) {
            leftIndex = start;
        } else if (A[end] == target) {
            leftIndex = end;
        } else {
            leftIndex = -1;
        }
        
        start = 0;
        end = A.length - 1;
        int rightIndex = 0;
        //rightbound
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[end] == target) {
            rightIndex = end;
        } else if (A[start] == target) {
            rightIndex = start;
        } else {
            rightIndex = -1;
        }
        
        int[] rst = new int[2];
        rst[0] = leftIndex;
        rst[1] = rightIndex;
        return rst;
    }
}


