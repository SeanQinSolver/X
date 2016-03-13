class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        if (A == null || A.length == 0) return;
        int posNum = 0, negNum = 0;
        for (int i : A) {
            if (i > 0) {
                posNum++;
            } else {
                negNum++;
            }
        }
        
        int posIndex = 0, negIndex = 1;
        if (posNum < negNum) {
            posIndex = 1;
            negIndex = 0;
        }
        
        while (posIndex < A.length && negIndex < A.length) {
            while (posIndex < A.length && A[posIndex] > 0) {
                posIndex += 2;
            }
            while (negIndex < A.length && A[negIndex] < 0) {
                negIndex += 2;
            }
            if (posIndex < A.length && negIndex < A.length) {
                exch(posIndex, negIndex, A);
            }
        }
    }
    private void exch(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}