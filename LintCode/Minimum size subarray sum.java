//method1, time will exeed
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
            sum = 0;
            sum += nums[i];
            if (sum >= s) {
                distance = 0;
                continue；//若单个以达到则可continue 或者break
            }
            for (j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    distance = Math.min(distance, j - i);
                    break;//break内部循环直接再到外部
                }
            }
        }
        if (distance == Integer.MAX_VALUE) {
            return -1;
        }
        return distance + 1;
    }
}

//method1二次循环依次计算

//method2

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

//用j去追踪右边界。若超过s，则减去左边界继续运算