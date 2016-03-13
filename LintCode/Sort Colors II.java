class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null) {
            return;
        }
        sort(colors, 0, colors.length - 1);
    }
    
    private void sort(int[] colors, int lo, int hi) {
        if (lo >= hi) return;
        int temp = partition(colors, lo, hi);
        sort(colors, lo, temp - 1);
        sort(colors, temp + 1, hi);
    }
    
    private int partition(int[] colors, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(colors[++i], colors[lo])) {
                if (i == hi) break;
            }
            while (less(colors[lo], colors[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(colors, i, j);
        }
        exch(colors, lo, j);
        return j;
    }
    
    private boolean less(int a, int b) {
        return a - b < 0;
    }
    
    private void exch(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}