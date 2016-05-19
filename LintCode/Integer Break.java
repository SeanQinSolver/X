//method1

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i + j <= n) {
                    dp[i + j] = Math.max(Math.max(dp[i], i) * Math.max(dp[j], j), dp[i + j]);
                    System.out.println(dp[i + j] +  "  " + i + "  " + j);
                }
            }
        }
        return dp[n];
    }
}
//dp[i] is max production value of breaking the number i


//method2

2 -> 1*1
3 -> 1*2
4 -> 2*2
5 -> 3*2
6 -> 3*3
7 -> 3*4
8 -> 3*3*2
9 -> 3*3*3
10 -> 3*3*4
11 -> 3*3*3*2

We only need to find how many three's we can get when n> 4. If n%3==1, we do not want 1 to be one of the broken numbers, we want 4.

public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        
        int result = 1;
        if (n % 3 == 0) {
            int m = n / 3;
            result = (int)Math.pow(3, m);
        } else if (n % 3 == 2) {
            int m = n / 3;
            result = (int)Math.pow(3, m) * 2;
        } else if (n % 3 == 1) {
            int m = (n - 4) / 3;
            //we don't want 1 to be the broken numbers, so we want 4.
            result = (int)Math.pow(3, m) * 4;
        }
        return result;
    }å
}
//
