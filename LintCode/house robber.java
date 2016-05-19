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
        
        //也可以设置dp长度为n，然后dp[0] = num[0], dp[1] = num[1]
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
            d[i] = Math.max(b[i-1], d[i-1]); //不抢I个，那么I-1可以被抢或者不抢，取其最大值
        }

        return Math.max(d[n-1], b[n-1]);
    }
}

//metho3

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     *
     */
    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) return 0;;
        
        int len = A.length;
        // dp[i] 表达打劫i房间为止所活动的收获 ，与dp[i-2] dp[i-3]有关
        //i被打劫了，只能i-2再被打劫或i-3再被打劫
        long[] dp = new long[len];
        dp[0] = A[0];
        if (len == 1) {
            return dp[0];
        } else if (len == 2) {
            dp[1] = A[1];
            return Math.max(dp[1], dp[0]);
        } else if (len == 3) {
            dp[1] = A[1];
            dp[2] = A[0] + A[2];
            return Math.max(dp[1], dp[2]);
        }
        dp[1] = A[1];
        dp[2] = A[0] + A[2];
        for (int i = 3; i < len; i++) {
            dp[i] = A[i] + Math.max(dp[i - 2], dp[i - 3]);
        }
        return Math.max(dp[len - 2], dp[len - 1]);
    }
}