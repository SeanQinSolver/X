//method1
public class Solution {
    public int minPatches(int[] nums, int n) {
        int res = 0, i = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                ++res;
            }
        }
        return res;
    }
}