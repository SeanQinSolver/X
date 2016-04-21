public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i] && (dp[i] < dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        //遍历求得最大的值
        int maxLen = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }
        return maxLen;
    }
}
//dp[i]为前i个数字中以i结尾的长度, 然后先将所有的dp赋值为1，因为至少一个字母


//写法2

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i] && (dp[i] < dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        
        return maxLen;
    }
}
//dp[i]为前i个数字中以i结尾的长度, 然后先将所有的dp赋值为1，因为至少一个字母