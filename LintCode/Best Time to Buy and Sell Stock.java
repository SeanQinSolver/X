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
        for (int i : prices) {
            //min来记录最小的值
            min = i < min ? i : min;
            //比较每个点的PROFIT与历史最大PROFIT
            profit = (i - min) > profit ? i - min : profit;
        }
        return profit;
    }
}