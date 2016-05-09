public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        //s.length个字符再包括0个字符一共s.length() + 1个字符
        int[] dp = new int[s.length() + 1];
        //0个字符只有一种decode方法
        dp[0] = 1;
        
        
        if (isValid(s.substring(0, 1))) {
            //一个字符或许有1种或没有
            dp[1] = 1;
        } else {
            dp[1] = 0;
        }
        
        //走一步或者两步
        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i - 1, i))) {
                dp[i] += dp[i - 1];
            }
            if (isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        //s should be "134" like digits
        int value = Integer.parseInt(s);
        return value >= 1 && value <= 26;
    }
}