public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        int count = 0;
        if (A == null || A.length == 0) {
            return count;
        }
        
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int startIndex = -1;
        if (A[start] == target) {
            startIndex = start;
        } else if (A[end] == target) {
            startIndex = end;
        } else {
            return 0;
        }
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int endIndex = -1;
        if (A[end] == target) {
            endIndex = end;
        } else if (A[start] == target) {
            endIndex = start;
        } else {
            return 0;
        }
        count = endIndex - startIndex + 1;
        return count;
    }
}
