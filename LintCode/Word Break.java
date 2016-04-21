public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() +  1];
        
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
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
                if (i -  j > maxLen) break;
                
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

