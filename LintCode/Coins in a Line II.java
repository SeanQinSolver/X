//Better 写法
public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int len = values.length;
        
        if (len <= 2) return true;
        //DP[i]代表i到end能取到的最大值
        int[] dp = new int[len + 1];
        dp[len] = 0;
        dp[len - 1] = values[len - 1];
        dp[len - 2] = values[len - 1] + values[len - 2];
        dp[len - 3] = values[len - 3] + values[len - 2];
        for (int i = len - 4; i >= 0; i--) {
            //取values[i]
            dp[i] = values[i] + Math.min(dp[i + 2], dp[i + 3]);
            //取values[i], values[i + 1]
            dp[i] = Math.max(dp[i], values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4]));
        }
        
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        return dp[0] > sum - dp[0];
    }
}





public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int[] dp = new int[values.length + 1];
        boolean[] flag = new boolean[values.length + 1];
        int sum = 0;
        for (int now : values) {
            sum += now;
        }
        //超过sum的一半即beat另一个选手
        return sum < 2 * MemorySearch(values.length, dp, flag, values);
    }
    public int MemorySearch(int n, int[] dp, boolean[] flag, int[] values) {
        if (flag[n] == true) {
            return dp[n];
        }
        flag[n] = true;
        if (n == 0) {
            dp[n] = 0;
        } else if (n == 1) {
            dp[n] = values[values.length - 1];
        } else if (n == 2) {
            dp[n] = values[values.length - 1] + values[values.length - 2];
        } else if (n == 3) {
            dp[n] = values[values.length - 2] + values[values.length - 3];
        } else {
            dp[n] = Math.max(
                             Math.min(MemorySearch(n-2, dp, flag,values) , MemorySearch(n-3, dp, flag, values)) + values[values.length-n],
                             Math.min(MemorySearch(n-3, dp, flag, values), MemorySearch(n-4, dp, flag, values)) + values[values.length-n] + values[values.length - n + 1]
                             );
        }
        return dp[n];
    }
}


///dp[idx]表示从第idx个硬币到最后一个硬币所能拿到的最大value，因为对手也取最优策略，所以每次取完后要对手会留给我们两种方案，我们只能取价值更小的一种方案。

//也是顺序拿硬币，拿1或者2个，但是每个硬币面值不同，问先手是否能稳赢？
// 这题的第一感觉是暴力搞，能拿2个就拿两个，于是有了一下反例：
// coins = [2 1 9 9]
// 先手如果一上来就拿2个，那么先手只能拿到3
// 如果先手上来只拿2，那么后手肯定要拿1和9，然后先手再拿9，于是先手赢
// 所以，不能每次都拿两个！！！！
// 说白了也是阶段性决策的问题。可是我们还能不能用之前的recurrence呢？
// win[n] = !(win[n-1] && win[n-2])
// 答案是不能！因为即便能保证w[n-1]和win[n-2]稳赢，也不能说明win[n]输。原因是我们这次的规则是比大小，如果我先拿了一个很大很大的coin，那么我手中持有的面值就使得输赢不取决于n-1和n-2了。
// 由于不是单纯的bool逻辑，我们用dp的时候需要在子问题里面考虑数值。
// 定义子问题dp【i】为, coin[i->n]，的序列中，先手能拿到的最大值。因为最后只需要判读dp[0] * 2 > sum[0]就好了
// 【定义：sum【i】为coin[i->n]的和】！！！！
// 于是先出转移方程：
// dp【i】 = max( sum【i】 - dp[i+1] , sum【i】 - dp[i+2] ) = sum【i】 - min( dp[i+1] , dp[i+2] )
----------------