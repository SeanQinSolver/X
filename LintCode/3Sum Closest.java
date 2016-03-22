public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums ,int target) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left <  right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                
                closest = Math.abs(sum - target) < Math.abs(closest - target) ? sum : closest;
            }
        }
        return closest;
    }
}

//two pointers to track each position from left to right.
//排序 + 2 sum + 2 pointers
