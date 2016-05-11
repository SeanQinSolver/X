public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        
        int maxLen = getMaxLen(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        
        for (int i = 1; i <= s.length(); i++) {
            //dp[i] = false;
            for (int currentLen = 1; currentLen <= maxLen && currentLen <= i; currentLen++) {
                if (!dp[i - currentLen]) continue;
                
                String temp = s.substring(i - currentLen, i);
                if (wordDict.contains(temp)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    private int getMaxLen(Set<String> wordsDict) {
        int len = Integer.MIN_VALUE;
        for(String s : wordsDict) {
            len = Math.max(len, s.length());
        }
        return len;
    }
    
}


//写法2

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    
    
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int maxLen = Integer.MIN_VALUE;
        for (String sx : dict) {
            maxLen = Math.max(maxLen, sx.length());
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                 //j到i的距离切成字
                if (i -  j > maxLen) break;
                if (!dp[j]) continue;
                String temp = s.substring(j, i);
                if (dp[j] && dict.contains(temp)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

