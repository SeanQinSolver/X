public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int pivot = nums[end];
            
            if (nums[mid] < pivot) {
                end = mid;
            } else if (nums[mid] > pivot) {
                start = mid;
            } else {
                end = end - 1;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}

//method2//sequential search

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}