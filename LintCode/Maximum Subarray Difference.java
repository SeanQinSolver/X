public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        int size = nums.length;
        int[] right_max = new int[size];
        int[] left_max = new int[size];
        int[] right_min = new int[size];
        int[] left_min = new int[size];
        int[] copy = new int[size];
        /*get the negative copy*/
        for (int i = 0; i < size; i++) {
            copy[i] = -1 * nums[i];
        }
        //forward: get max subarray
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left_max[i] = max;
        }
        //forward: get min subarray
        sum = 0;
        max = 0;
        minSum = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            max = Math.max(sum, max);
            sum += nums[i];
            minSum = Math.min(minSum, sum - max);
            left_min[i] = minSum;
        }
        //backward: get max subarray
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right_max[i] = max;
        }
        //backward: get min subarray
        sum = 0;
        max = 0;
        minSum = Integer.MAX_VALUE;
        for(int i = size - 1; i >= 0; i--) {
            max = Math.max(sum, max);
            sum += nums[i];
            minSum = Math.min(minSum, sum - max);
            right_min[i] = minSum;
        }
        
        int diff = 0;
        for (int i = 0; i < size - 1; i++) {
            diff = Math.max(diff, Math.abs(left_max[i] - right_min[i + 1]));
            diff = Math.max(diff, Math.abs(left_min[i] - right_max[i + 1]));
        }
        return diff;
    }
}

//此题比较麻烦，相应求出从左到右的每个index对应的max, min.然后求left.max - right.min或者left.min - right.max的绝对值的最大值
