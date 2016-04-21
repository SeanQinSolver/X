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


//merge sort

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        int[] Aux = new int[colors.length];
        sort(0, colors.length - 1, colors, Aux);
    }
    
    private void merge(int lo, int hi, int mid, int[] A, int[] Aux) {
        for (int i = lo; i <= hi; i++) {
            Aux[i] = A[i];
        }
        
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) A[k] = Aux[j++];
            else if (j > hi) A[k] = Aux[i++];
            else if (Aux[j] < Aux[i]) A[k] = A[j++];
            else A[k] = Aux[i++];
        }
    }
    
    private void sort(int lo, int hi, int[] A, int[] Aux) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(lo, mid, A, Aux);
        sort(mid + 1, hi, A, Aux);
        merge(lo, hi, mid, A, Aux);
    }
}