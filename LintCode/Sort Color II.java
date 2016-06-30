//method1 quick sort
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null) return;
        quickSort(colors, 0, colors.length - 1);
    }
    //牢记pivot为A[lo]
    private int partition(int[] A, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(A[++i], A[lo])) {
                if (i == hi) break;
            }
            while (less(A[lo], A[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(A, i, j);
        }
        exch(A, lo, j);
        return j;
    }
    
    private void quickSort(int[] A, int lo, int hi) {
        if (lo >= hi) return;
        int k = partition(A, lo, hi);
        quickSort(A, lo, k - 1);
        quickSort(A, k + 1, hi);
    }
    
    private void exch(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    private boolean less(int a, int b) {
        return a < b;
    }
}

//method2

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        int start = 0;
        int end = colors.length - 1;
        int i = 0;
        int min = 1, max = k;
        while (min < max) {
            while (i <= end) {
                if (colors[i] == min) {
                    swap(colors, start, i);
                    i++;
                    start++;
                } else if (colors[i] == max) {
                    swap(colors, end, i);
                    end--;
                } else {
                    i++;
                }
            }
            i = start;
            min++;
            max--;
        }
    }
    
    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
