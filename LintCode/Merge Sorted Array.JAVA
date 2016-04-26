class Solution {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int mergeIndex = m + n - 1;
        int lastIndexA = m - 1;
        int lastIndexB = n - 1;
        
        while (lastIndexB >= 0) {
            if (lastIndexA >= 0 && A[lastIndexA] > B[lastIndexB]) {
                A[mergeIndex] = A[lastIndexA];
                lastIndexA--;
            } else {
                A[mergeIndex] = B[lastIndexB];
                lastIndexB--;
            }
            mergeIndex--;
        }
    }
}