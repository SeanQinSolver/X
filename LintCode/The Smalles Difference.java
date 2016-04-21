public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int point1 = 0;
        int point2 = 0;
        int res = Integer.MAX_VALUE;
        while (point1 < A.length && point2 < B.length) {
            if (A[point1] <= B[point2]) {
                res = Math.min(res, B[point2] - A[point1++]);
            } else {
                res = Math.min(res, A[point1] - B[point2++]);
            }
        }
        return res;
    }
}
