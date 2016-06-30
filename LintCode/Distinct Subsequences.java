//method1
会TLD
public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S == null || T == null) return 0;
        if (S.length() < T.length()) return 0;
        if (T.length() == 0) return 1;
        
        int num = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                num += numDistinct(S.substring(i + 1), T.substring(1));
            }
        }
        return num;
    }
}

//method2



public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S == null || T == null) return 0;
        if (S.length() < T.length()) return 0;
        if (T.length() == 0) return 1;
        
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        
        for (int i = 0; i < S.length(); i++) {
            dp[i][0] = 1;
            for (int j = 0; j < T.length(); j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        
        return dp[S.length()][T.length()];
    }
}


//定义dp[i][j]为S[0 : i]中子序列为T[0 : J]的个数
//若S.charAt(i) == S.charAt(j)则有两种选择，一种是不配对dp[i][j + 1]，一个是把最后一个算上配对dp[i][j]
//若S.charAt(i) ！= S.charAt(j)， 则只能不配对dp[i][j + 1]

//写法3

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S.length() == 0 || S == null) return 0;
        else if (T.length() == 0 || T == null) return 1;
        if (S.length() < T.length()) return 0;
        
        int m = S.length();
        int n = T.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    //dp[i - 1][j]是S跳过i
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}