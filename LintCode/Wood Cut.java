public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        int start = 1;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start + " " + end);
        if (count(L, end) >= k) {
            return end;
        } else if (count(L, start) >= k) {
            return  start;
        } else {
            return 0;
        }
    }
    private int count(int[] L, int length) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / length;
        }
        return sum;
    }
}

//practice 2

public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i : L) {
            max = Math.max(i, max);
        }
        int start = 1;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (cal(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //此题注意先检测start再检测end
        if (cal(L, start) >= k) {
            return start;
        } else if(cal(L, end) >= k){
            return end;
        } else {
            return 0;
        }
    }
    private int cal(int[] L, int divisor) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / divisor;
        }
        return sum;
    }
}