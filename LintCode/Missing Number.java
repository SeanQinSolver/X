//method1 等差数列求和减去sum
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int n = nums.length;
        for (int i : nums) sum += i;
        return n * (n + 1) / 2 - sum;
    }
}

//method2 bit 运算

public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }
}