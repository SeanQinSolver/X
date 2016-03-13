//merge sort
class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    //mergesort
    public void sortColors(int[] nums) {
        int[] aux = new int[nums.length];
        sort(0, nums.length - 1, nums, aux);
    }
    private void merge(int lo, int mid, int hi, int[] a, int[] aux) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    private void sort(int lo, int hi, int[] a, int[] aux) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(lo, mid, a, aux);
        sort(mid + 1, hi, a, aux);
        merge(lo, mid, hi, a, aux);
    }
}

//heap sort

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    //mergesort
    public void sortColors(int[] nums) {
        int[] numsTemp = new int[nums.length + 1];
        numsTemp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            numsTemp[i + 1] = nums[i];
        }
        buildHeap(numsTemp);
        int len = numsTemp.length - 1;
        while (len > 1) {
            exch(1, len--, numsTemp);
            sink(1, numsTemp, len);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsTemp[i + 1];
        }
    }
    
    private void buildHeap(int[] A) {
        int len = A.length;
        for (int k = len / 2; k >= 1; k--) {
            sink(k, A, len);
        }
    }
    private void sink(int k, int[] A, int len) {
        while (2 * k < len) {
            int j = 2 * k;
            if (j + 1 < len && A[j] < A[j + 1]) {
                j++;
            }
            if (A[k] >= A[j]) break;
            exch(k, j, A);
            k = j;
        }
    }
    private void exch(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
//3 pointer one way
class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    //3 pointer
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int index = 0;
        while (index < blue + 1) {
            if (nums[index] == 0) {
                exch(index, red, nums);
                index++;
                red++;
                continue;
            }
            if (nums[index] == 2) {
                exch(index, blue, nums);
                blue--;
                continue;
            }
            index++;
        }
    }
    
    private void exch(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}