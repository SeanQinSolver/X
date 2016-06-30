eeepublic class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        int target = nums[end];
        
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        
        if (nums[start] <= target) {
            return nums[start];
        } else if (nums[end] <= target) {
            return nums[end];
        } else {
            return -1;
        }
    }
}