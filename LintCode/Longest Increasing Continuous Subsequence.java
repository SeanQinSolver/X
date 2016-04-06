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

//写法2

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        int result = 1;
        if (A.length == 0 || A == null) return 0;
        boolean fromLeft = true;
        int start = 0;
        for (int i = start; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (fromLeft == true) {
                    result = Math.max(result, i + 1 - start + 1);
                } else {
                    start = i;
                    fromLeft = true;
                }
            } else if (A[i] > A[i + 1]) {
                if (fromLeft == false) {
                    result = Math.max(result, i + 1 - start + 1);
                } else {
                    start = i;
                    fromLeft = false;
                }
            }
        }
        return result;
    }
}

//此题注意用一个flag去判断是否从小到大或大到小然后flag变换。
//还有一点起初 result应该为1.