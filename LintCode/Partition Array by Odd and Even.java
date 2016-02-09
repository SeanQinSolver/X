public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int even = nums.length;
        for (int i = 0; i < even; i++) {
            if (nums[i] % 2 == 0) {
                int tmp = nums[i];
                nums[i] = nums[--even];
                nums[even] = tmp;
                i--;
            }
        }
    }
}