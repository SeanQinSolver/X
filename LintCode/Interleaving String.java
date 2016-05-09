//Interleaving String recursion
public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = (s1 == null) ? 0 : s1.length();
        int len2 = (s2 == null) ? 0 : s2.length();
        int len3 = (s3 == null) ? 0 : s3.length();
        
        if (len3 != len1 + len2) return false;
        int i1 = 0, i2 = 0;
        for (int i3 = 0; i3 < len3; i3++) {
            boolean result = false;
            if (i1 < len1 && i2 < len2 && s1.charAt(i1) == s3.charAt(i3) && s2.charAt(i2) == s3.charAt(i3)) {
                boolean case1 = isInterleave(s1.substring(i1 + 1), s2.substring(i2), s3.substring(i3 + 1));
                boolean case2 = isInterleave(s1.substring(i1), s2.substring(i2 + 1), s3.substring(i3 + 1));
                return case1 || case2;
            }
            if (i1 < len1 && s1.charAt(i1) == s3.charAt(i3)) {
                i1++;
                result = true;
                continue;
            }
            if (i2 < len2 && s2.charAt(i2) == s3.charAt(i3)) {
                i2++;
                result = true;
                continue;
            }
            if (!result) {
                return false;
            }
        }
        return true;
    }
}
//此题思路是dp。如果两个相等

//method2 dp

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int len1 = (s1 == null) ? 0 : s1.length();
        int len2 = (s2 == null) ? 0 : s2.length();
        int len3 = (s3 == null) ? 0 : s3.length();
        
        if (len1 + len2 != len3) return false;
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= len1; i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }
        
        for (int i = 1; i <= len2; i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1) && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
//此题思路是dp。如果两个相等
//dp[i][j]表示s1前i个和s2前j个对s3前i+j个是否interleaving


//写法3

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int len1 = (s1 == null) ? 0 : s1.length();
        int len2 = (s2 == null) ? 0 : s2.length();
        int len3 = (s3 == null) ? 0 : s3.length();
        
        if (len1 + len2 != len3) {
            return false;
        }
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }
        
        for (int i = 1; i <= len2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //s3的length是i + j - 1 因为 最右边的dp[i - 1][j]表示 i - 1 + j - 1个字符已经匹配了， 所以下一个匹配 i - 1 + j
                boolean case1 = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
                boolean case2 = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];
                dp[i][j] = case1 || case2;
            }
        }
        return dp[len1][len2];
    }
}

// 双重 for 循环，时间复杂度为 O(n^2)
//
// 使用了二维矩阵，空间复杂度 O(n^2)
//
// 其中空间复杂度可以优化。