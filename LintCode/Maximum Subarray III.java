public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        if (nums.length < k) return 0;
        
        int len = nums.length;
        int[][] dp = new int[len + 1][k + 1];
        
        for (int j = 1; j <= k; j++) {
            for (int i = j; i <= len; i++) {
                dp[i][j] = Integer.MIN_VALUE;
                int minSum = Integer.MAX_VALUE;
                int maxSum = Integer.MIN_VALUE;
                int sum = 0;
                for (int m = i - 1; m >= j - 1; m--) {
                    minSum = Math.min(sum, minSum);
                    sum += nums[m];
                    maxSum = Math.max(sum - minSum, maxSum);
                    if (dp[i][j] < dp[m][j - 1] + maxSum) {
                        dp[i][j] = dp[m][j - 1] + maxSum;
                    }
                }
            }
        }
        return dp[len][k];
    }
}

//method2

public int maxSubArray(ArrayList<Integer> nums, int k) {
// write your code
int n = nums.size();
int[][] d = new int[n+1][k+1];
for (int j = 1; j <= k; j++) {
for (int i = j; i <= n; i++) {
d[i][j] = Integer.MIN_VALUE;
int max = Integer.MIN_VALUE;
int localMax = 0;
for (int m = i-1; m >= j-1; m--) {
localMax = Math.max(nums.get(m), nums.get(m)+localMax);
max = Math.max(localMax, max);
d[i][j] = Math.max(d[i][j], d[m][j-1] + max);
}
}
}
return d[n][k];
}