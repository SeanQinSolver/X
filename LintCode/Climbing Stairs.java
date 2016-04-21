//dp
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 1) {
            return 1;
        }
        int[] fn = new int[n + 1];
        fn[0] = fn[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            fn[i] = fn[i - 1] + fn[i - 2];
        }
        return fn[n];
    }
}

//recursion TLD

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

//