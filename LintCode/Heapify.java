public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int len = A.length;
        //与平时不一样，需要check到0。pricenton只check到1
        for (int k = len / 2; k >= 0; k--) {
            sink(k, A, len);
        }
    }
    //注意此题和平时的题不一样,需要先确定左边的child有没有溢出
    private void sink(int k, int[] A, int len) {
        while (2 * k + 1 < len) {
            int j = 2 * k  + 1;
            if (j + 1 < len && less(A[j + 1], A[j])) j++;
            if (less(A[k], A[j])) break;
            exch(A, k, j);
            k = j;
        }
    }
    private boolean less(int a, int b) {
        return a - b < 0;
    }
    private void exch(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}