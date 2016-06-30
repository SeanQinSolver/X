public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        //注意这里要设置为零
        int preMin = 0;
        int preSec = 0;
        int preIndex = -1;
        
        for (int i = 0; i < costs.length; i++) {
            int currMin = Integer.MAX_VALUE;
            int currSec = Integer.MAX_VALUE;
            int currIndex = -1;
            for (int j = 0; j < costs[0].length; j++) {
                costs[i][j] = costs[i][j] + (preIndex == j ? preSec : preMin);
                if (costs[i][j] < currMin) {
                    currSec = currMin;
                    currMin = costs[i][j];
                    currIndex = j;
                } else if (costs[i][j] < currSec) {
                    currSec = costs[i][j];
                }
            }
            preMin = currMin;
            preSec = currSec;
            preIndex = currIndex;
        }
        return preMin;
    }
}

//https://segmentfault.com/a/1190000003903965
//此题需要保存preMin和preSec来，如果当前是同色的(j == preIndex)则匹配上一个row的房子的次小值
// 和I的思路一样，不过这里我们有K个颜色，不能简单的用Math.min方法了。如果遍历一遍颜色数组就找出除了自身外最小的颜色呢？我们只要把最小和次小的都记录下来就行了，这样如果和最小的是一个颜色，就加上次小的开销，反之，则加上最小的开销。
//时间 O(N) 空间 O(1)