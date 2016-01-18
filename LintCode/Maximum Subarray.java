//Method1 brutal
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {

    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(Math.max(max, temp + nums[j]), temp);
                temp += nums[j];
            }
        }
        return nums.length == ! ? temp : max;
    }
}

//Method2 DP

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}

//Method3 Greedy

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
}

