public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return result;
        }
        long a = 1;
        if (A.size() == 1) {
            result.add(a);
            return result;
        }
        
        long[] left = new long[A.size()];
        long[] right = new long[A.size()];
        
        left[0] = 1;
        for (int i = 0; i < A.size(); i++) {
            left[i] = left[i - 1] * A.get(i - 1);
        }
        
        right[A.size() - 1] = 1;
        for (int i = A.size() - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A.get(i + 1);
        }
        
        for (int i = 0; i < A.size(); i++) {
            result.add(left[i] * right[i]);
        }
        return result;
    }
}

//注意此题的i是 left[i-1] 和 A.get(i-1)
//右边是i 是right[i + 1] 和 A.get(i+1)
