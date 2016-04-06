public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0) {
            return null;
        }
        int index = findIndex(A, target);
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        
        result[0] = A[index];
        int left = index - 1;
        int right = index + 1;
        int count = 1;
        while (left >= 0 && right <= A.length - 1 && count < k) {
            //当相等时，需要先加左边的bound到result中
            if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
                result[count++]  = A[left--];
            } else {
                result[count++] = A[right++];
            }
        }
        while (left < 0 && right <= A.length - 1 && count < k) {
            result[count++] = A[right++];
        }
        while (left >= 0 && right > A.length - 1 && count < k) {
            result[count++] = A[left--];
        }
        return result;
    }
    private int findIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                //！！
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
            return start;
        } else {
            return end;
        }
    }
}

//此题注意在findindex时的binary search下一轮的时候需要包括mid
//

