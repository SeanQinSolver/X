public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int[] profit_front = new int[prices.length];
        profit_front[0] = 0;
        int valley = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit_front[i] = Math.max(profit_front[i - 1], prices[i] - valley);
            valley = Math.min(valley, prices[i]);
        }
        
        int[] profit_end = new int[prices.length];
        profit_end[prices.length - 1] = 0;
        int peak = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            profit_end[i] = Math.max(profit_end[i + 1], peak - prices[i]);
            peak = Math.max(peak, prices[i]);
        }
        
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, profit_front[i] + profit_end[i]);
        }
        return profit;
    }
}