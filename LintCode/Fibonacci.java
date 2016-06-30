class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] fib = new int[n + 1];
        fib[1] = 0;
        fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}


//better写法

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if (n <= 0) return -1;
        if (n == 1) return 0;
        if (n == 2) return 1;
        
        int[] dp = new int[n];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }
}

