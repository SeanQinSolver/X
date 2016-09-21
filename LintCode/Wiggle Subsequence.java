//dp o(n2)

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int[] sign = new int[nums.length];
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ((j > 0 && nums[j] == nums[j - 1]) || (nums[i] == nums[j])) {
                    continue;
                }
                if ((sign[j] > 0 && nums[i] < nums[j]) || (sign[j] < 0 && nums[i] > nums[j]) || sign[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        if (nums[i] != nums[j]) {
                            sign[i] = nums[i] > nums[j] ? 1 : -1;
                        }
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        
        int res = Integer.MIN_VALUE;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }
}


//greedy o(n)
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int ans = 1;
        for (int i = 1, j = 0; i < len; j = i, i++) {
            if (nums[j] < nums[i]) {
                ans++;
                while (i + 1 < len && nums[i] <= nums[i + 1]) {
                    i++;
                }
            } else if (nums[j] > nums[i]) {
                ans++;
                while (i + 1 < len && nums[i] >= nums[i + 1]) {
                    i++;
                }
            }
        }
        return ans;
    }
}

//o(n)
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}