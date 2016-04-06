class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int i = A.length - 1;
        int j = B.length - 1;
        int newLen = i + j + 2;
        int index = i + j + 1;
        int[] new1 = new int[newLen];
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                new1[index--] = A[i--];
            } else {
                new1[index--] = B[j--];
            }
        }
        while (i >= 0) {
            new1[index--] = A[i--];
        }
        while (j >= 0) {
            new1[index--] = B[j--];
        }
        return new1;
    }
}