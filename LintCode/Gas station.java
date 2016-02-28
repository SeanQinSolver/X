public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return 0;
        }
        int index = -1;
        int record = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            //记录起点
            sum += gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
            //记录总和，若能循环则record最后不为零
            record += gas[i] - cost[i];
        }
        return record < 0 ? -1 : index + 1;
    }
}