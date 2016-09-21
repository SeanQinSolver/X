 //O(n^2 )
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
//dp[i]为连续递增前i个数字中以i结尾的长度, 然后先将所有的dp赋值为1，因为一个数字可以看做长度为一的递增。


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


//注意leetcode的cornercase

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //这个nums[j] < nums[i]与lintcode不一样. lintcodes是小于等于
                if (nums[j] < nums[i] && (dp[i] < dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 1 : max;
    }
}

//binary search nlogn
public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> endNum = new ArrayList<>();
        for (int num : nums) {
            if (endNum.isEmpty() || endNum.get(endNum.size() - 1) < num) {
                endNum.add(num);
            } else {
                endNum.set(getFirstEorL(endNum, num), num);
            }
        }
        return endNum.size();
    }
    
    private int getFirstEorL(List<Integer> endNum, int num) {
        int start = 0;
        int end = endNum.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (endNum.get(mid) < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}