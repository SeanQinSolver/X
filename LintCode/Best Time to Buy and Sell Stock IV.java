class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;
        
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        
        int n = prices.length;
        //mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] mustSell = new int[n][k + 1];
        //globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益
        int[][] global = new int[n][k + 1];
        
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                //mustSell[i - 1][j] 相当于j - 1天又有买入又有卖出，相抵消
                mustSell[i][j] = Math.max(global[i - 1][j - 1] + diff, mustSell[i - 1][j] + diff);
                //全局最优，第i-1天取j次交易 和 第i天j次交易i第j天必sell的最大值
                global[i][j] = Math.max(global[i - 1][j], mustSell[i][j]);
            }
        }
        return global[n - 1][k];
    }
};

