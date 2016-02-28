public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max_local = nums[0];
        int min_local = nums[0];
        int global = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int max_copy = max_local;
            //max_local记录最大值
            max_local = Math.max(Math.max(nums[i] * max_local, nums[i]), nums[i] * min_local);
            //min_local记录最小值
            min_local = Math.min(Math.min(nums[i] * max_copy, nums[i]), nums[i] * min_local);
            global = Math.max(max_local, global);
        }
        return global;
    }
}