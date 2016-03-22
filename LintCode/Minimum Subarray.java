public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        int sum = 0;
        int maxSum = 0;
        int minSum = Integer.MAX_VALUE;
        for (int num : nums) {
            maxSum = Math.max(maxSum, sum);
            sum += num;
            minSum = Math.min(minSum, sum - maxSum);
        }
        return minSum;
    }
}
//此题的重点先存储之前的maxSum,然后让sum加上现在的num。然后minSum和现在的sum - maxSum比较
