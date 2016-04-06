class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1, k);
    }
    private int helper(int[] nums, int lo, int hi, int k) {
        if (hi <= lo) return nums[lo];
        int position = partition(nums, lo, hi);
        if (position == nums.length - k) {
            //System.out.println(position);
            return nums[position];
        } else if (position < nums.length - k) {
            return helper(nums, position + 1, hi, k);
        } else {
            return helper(nums, lo, position - 1, k);
        }
    }
    
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(nums[++i], nums[lo])) {
                if (i == hi) break;
            }
            while (!less(nums[--j], nums[lo])) {
                if (j == lo) break;
            }
            if (i >= j) {
                break;
            }
            exch(nums, i, j);
        }
        exch(nums, j, lo);
        return j;
    }
    
    private boolean less(int a, int b) {
        return a - b < 0;
    }
    
    private void exch(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
};

//此题思路QUICK SORT