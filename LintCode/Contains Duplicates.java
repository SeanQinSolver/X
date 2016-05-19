//method1 TLE.
//time o（n）
//space o(1)
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null) return false;
        if (nums.length == 1) return false;
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }
}

//method2。 空间换时间

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null) return false;
        if (nums.length == 1) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }
}
