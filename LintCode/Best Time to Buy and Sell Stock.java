public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i : prices) {
            min = min < i ? min : i;
            profit = (i - min) > profit ? (i - min) : profit;
            //or:
            //profit = price - min > 0 ? Math.max(price - min, profit) : profit;
        }
        return profit;
    }
}