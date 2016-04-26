public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if (n <= 1 || k <= 0) {
            return n * k;
        }
        //n个FENCE,所以一定要到N, 0-N为 N + 1个
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k + k * (k - 1);
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}




// S(N) means last 2 fence posts have same color. So S(n) will equal to D(n - 1).
// because n - 2 should not be painted. Thus. S(n) = D(n - 1).

// D(N) means last 2 fences post different colors. we have two different conditions when k(colors) is 2:

// for k = 2 example : xxy  wxy   //y is the tail.

// for k = 3 :   xxy wxy wzy zzy //

// thus D(N) = (k - 1) * (D(n - 1) + S(n - 1));

// The total result can be: T(n) = S(n) + D(n):
// T(N) = S(N) + D(N) = D(N - 1) + (k - 1) * (D(N - 1) + S(N - 1))
//                     = D(N - 1) + (k - 1) (T(n - 1))
//                     = (k - 1) * (D(N - 2) + S(N - 2) + T(N - 1)) = (k - 1)(T(N - 1) + T(N - 2))

//                     Since N - 2 >= 1， so N >= 3， we need to care the base case  on 0, 1, 2
//                     N = 0 ---> 0;
//                     k = 0 ---> 0;
//                     N = 1 ---> just K ways