//写法1
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int n = A.size();
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A.get(i));
        }
        
        int[][] dp = new int[n][max + 1];
        
        //第0个数分别调整成从0到最大值的花费
        for (int j = 0; j <= max; j++) {
            dp[0][j] = Math.abs(A.get(0) - j);
        }
        
        int curMin = 0;
        for (int i = 1; i < n; i++) {
            curMin = Integer.MAX_VALUE;
            for (int j = 0; j <= max; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int lower = Math.max(0, j - target);
                int upper = Math.min(max, j + target);
                for (int k = lower; k <= upper; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A.get(i) - j));
                    curMin = Math.min(curMin, dp[i][j]);
                }
            }
        }
        return curMin;
    }
}
// state: f[i][v]前i个数，第i个数调整为v,满足相邻两数<=target，所需要的最小代价
// function: f[i][v] = min(f[i - 1][v'] + |A[i] - v|, |v- v'| <= target)

//如果第i-1个数是j, 那么第i-2个数只能在[lowerRange, UpperRange]之间，lowerRange=Math.max(0, j-target), upperRange=Math.min(99, j+target),

// 这样的话，transfer function可以写成：

// for (int p=lowerRange; p<= upperRange; p++) {

// 　　res[i][j] = Math.min(res[i][j], res[i-1][p] + Math.abs(j-A.get(i-1)));

// }


//写法2
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        
        int[][] D = new int[A.size()][101];
        
        int size = A.size();
        
        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= 100; j++) {
                D[i][j] = Integer.MAX_VALUE;
                if (i == 0) {
                    //The first element
                    D[i][j] = Math.abs(j - A.get(i));
                } else {
                    for (int k = 1; k <= 100; k++) {
                        //不符合条件
                        if (Math.abs(j - k) > target) {
                            continue;
                        }
                        
                        int dif = Math.abs(j - A.get(i)) + D[i - 1][k];
                        D[i][j] = Math.min(D[i][j], dif);
                    }
                }
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            ret = Math.min(ret, D[size - 1][i]);
        }
        return ret;
    }
}
// state: f[i][v]前i个数，第i个数调整为v,满足相邻两数<=target，所需要的最小代价
// function: f[i][v] = min(f[i - 1][v'] + |A[i] - v|, |v- v'| <= target)