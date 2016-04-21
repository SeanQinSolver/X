public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        int[] dp = new int[n+1];
        return MemorySearch(n, dp);
    }
    public boolean MemorySearch(int n, int[] dp) {
        if (dp[n] != 0) {
            if (dp[n] == 1) {
                return false;
            } else {
                return true;
            }
        }
        if (n <= 0) {
            dp[n] = 1;
        } else if (n == 1) {
            dp[n] = 2;
        } else if (n == 2) {
            dp[n] = 2;
        } else if (n == 3) {
            dp[n] = 1;
        } else {
            if ((MemorySearch(n - 2, dp) && MemorySearch(n - 3, dp)) || (MemorySearch(n - 3, dp) && MemorySearch(n - 4, dp))) {
                dp[n] = 2;
            } else {
                dp[n] = 1;
            }
        }
        if (dp[n] == 2) {
            return true;
        }
        return false;
    }
}


//http://www.meetqun.com/thread-10440-1-1.html


//method2

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        if (n % 3 == 0) return false;
        return true;
    }
}
//只要个数不是3的倍数，则第一手可以赢