public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        int distance = Integer.MAX_VALUE;
        //注意此时right指针要到nums.length
        while (start < nums.length && end < nums.length) {
            while (sum < s && end < nums.length) {
                sum += nums[end++];
            }
            while (sum >= s && start <= end) {
                distance = Math.min(distance, end - start);
                sum -= nums[start++];
            }
        }
        return distance == Integer.MAX_VALUE ? 0 : distance;
    }
}

//双指针维护一个窗口

//写法2

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int i = 0, j = 0;
        int distance = Integer.MAX_VALUE;
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                System.out.println(j + " " + i + "**");
                distance = Math.min(distance, j - i);
                sum -= nums[i];
            }
        }
        if (distance == Integer.MAX_VALUE) {
            return -1;
        }
        return distance;
    }
}