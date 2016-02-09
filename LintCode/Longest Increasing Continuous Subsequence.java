public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
       int res = 0;
       if (A == null || A.length == 0) {
           return res;
       }
       boolean fromLeft = true;
       int start = 0;
       res = 1;
       for (int i = 1; i < A.length; i++) {
           if (A[i] > A[i - 1]) {
               if (fromLeft == true) {
                   res = Math.max(res, i - start + 1);
               } else {
                   start = i - 1;
                   fromLeft = true;
               }
           } else if (A[i] < A[i - 1]) {
               if (fromLeft == false) {
                   res = Math.max(res, i - start + 1);
               } else {
                   start = i - 1;
                   fromLeft = false;
               }
           }
       }
       return res;
    }
}