public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                int j;
                for (j = len - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                swap(nums, i, j);
                reverse(nums, i + 1, len - 1);
                return nums;
            }
        }
        Arrays.sort(nums);
        return nums;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        }
        
        public void reverse(int[] num, int begin, int end) {
            for (int i = begin, j = end; i < j; i++, j--) {
                swap(num, i, j);
            }
        }
}