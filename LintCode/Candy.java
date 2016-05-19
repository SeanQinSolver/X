public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        //dp代表有此rating拿的candy个数
        int[] dp = new int[ratings.length];
        
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) dp[i] = dp[i - 1] + 1;
        }
        
        int sum = 0;
        for (int i = ratings.length - 1; i >= 1; i--) {
            sum += dp[i];
            
            //注意此循环是从最右边开始向左边走
            if (ratings[i - 1] > ratings[i] && dp[i - 1] <= dp[i]) {
                dp[i - 1] = dp[i] + 1;
            }
        }
        sum += dp[0];
        return sum;
    }
}

