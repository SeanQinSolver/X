class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid - 1] > A[mid]) {
                end = mid;
            } else if (A[mid + 1] > A[mid]) {
                start = mid;
            } else {
                end = mid;
                // or return mid
            }
        }
        
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}


