public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || V == null || A.length == 0 || V.length == 0) return 0;
        int N = A.length; // size array
        int M = m; //size limit
        //dp[i][j]表示在前i个物品在体积Limit j的情况下的最大值；
        int[][] dp = new int[N + 1][M + 1];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (A[i] > j) {
                    //超过体积限制
                    dp[i + 1][j] = dp[i][j];
                } else {
                    //没有超过
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - A[i]] + V[i]);
                }
            }
        }
        return dp[N][M];
    }
}



// http://algorithm.yuanbin.me/zh-hans/basics_algorithm/knapsack.html

// 上节讲述的是最原始的背包问题，这节我们探讨条件受限情况下的背包问题。若一件珠宝最多只能带走一件，请问现在抢劫犯该如何做才能使得背包中的珠宝价值总价最大？
// 显然，无界背包中的状态及状态方程已经不适用于01背包问题，那么我们来比较这两个问题的不同之处，无界背包问题中同一物品可以使用多次，而01背包问题中一个背包仅可使用一次，区别就在这里。我们将 K(\omega)K(ω) 改为 K(i,\omega)K(i,ω) 即可，新的状态表示前 ii 件物品放入一个容量为 \omegaω 的背包可以获得的最大价值。
// 现在从以上状态定义出发寻找相应的状态转移方程。K(i-1, \omega)K(i−1,ω)为 K(i, \omega)K(i,ω) 的子问题，如果不放第 ii 件物品，那么问题即转化为「前 i-1i−1 件物品放入容量为 \omegaω 的背包」，此时背包内获得的总价值为 K(i-1, \omega)K(i−1,ω)；如果放入第 ii 件物品，那么问题即转化为「前 i-1i−1 件物品放入容量为 \omega - \omega_iω−ω
// ​i
// ​​  的背包」，此时背包内获得的总价值为 K(i-1, \omega - \omega_i) + v_iK(i−1,ω−ω
// ​i
// ​​ )+v
// ​i
// ​​ . 新的状态转移方程用数学语言来表述即为： K(i,\omega) = \max \{K(i-1, \omega), K(i-1, \omega - \omega_i) + v_i\}K(i,ω)=max{K(i−1,ω),K(i−1,ω−ω
// ​i
// ​​ )+v
// ​i
// ​​ }
// 这里的分析是以容量递推的，但是在容量特别大时，我们可能需要以价值作为转移方程。定义状态dp[i + 1][j]为前i个物品中挑选出价值总和为j 时总重量的最小值（所以对于不满足条件的索引应该用充分大的值而不是最大值替代，防止溢出）。相应的转移方程为：前i - 1 个物品价值为j, 要么为j - v[i](选中第i个物品). 即dp[i + 1][j] = min{dp[i][j], dp[i][j - v[i]] + w[i]}. 最终返回结果为dp[n][j] ≤ W 中最大的 j.


//method2

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || V == null || A.length == 0 || V.length == 0){
            return 0;
        }
        int[] f = new int[m + 1];
        for (int i = 0; i < m; i++) f[i] = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= A[i]; j--) {
                if (f[j] < f[j - A[i]] + V[i]) {
                    f[j] = f[j - A[i]] + V[i];
                }
            }
        }
        return f[m];
    }
}