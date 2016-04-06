public class Solution {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            while(i <= j && less(nums[i], k)) {
                i++;
            }
            while (i <= j && !less(nums[j], k)) {
                j--;
            }
            if (i >= j) break;
            exch(nums, i, j);
            i++;
            j--;
        }
        return i;
    }
    private boolean less(int a, int b) {
        return a - b < 0;
    }
    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}