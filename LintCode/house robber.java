//method1  
//The key is to find the relation dp[i] = Math.max(dp[i-1], dp[i-2]+num[i-1]).
public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     * 、
     */
     
    public long houseRobber(int[] num) {
        if (num == null || num.length == 0) return 0;
        int n = num.length;
        
        long[] dp = new long[n + 1];

        dp[0] = 0;
        //对于一个House的值就是num[0]
        dp[1] = num[0];
        
        for (int i = 2; i <= n; i++) {
            //抢第i-1个:dp[i - 2] + num[i - 1]
            //不抢第i-1个:dp[i - 1]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i - 1]);
        }
        return dp[n];
    }
}
//metho2
public class Solution {
    public int rob(int[] num) {
        
        if(num==null || num.length==0) return 0;

        int n = num.length;

        int [] b = new int[n]; 
        int [] d = new int[n]; 

        b[0] = num[0];//include last element;
        d[0] = 0;//exclude last element;

        for(int i=1; i < n; i++) {
            b[i] = d[i-1] + num[i]; //抢第I个但不抢第I-1个。
            d[i] = Math.max(b[i-1], d[i-1]); //不抢I个，那么I-1可以被抢或者不抢
        }

        return Math.max(d[n-1], b[n-1]);
    }
}