public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.floor(n) != null && n <= t + set.floor(n) || set.ceiling(n) != null && set.ceiling(n) <= t + n) {
                return true;
            }
            set.add(n);
            if (i >= k) {
                set.remove(nums[i - k]); // 维护set的大小始终小于k
            }
        }
        return false;
    }
}

//method2
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null ||nums.length < 2) return false;
        
        SortedSet<Long> set = new TreeSet<Long>();
        
        for (int j = 0; j < nums.length; j++) {
            SortedSet<Long> subSet = set.subSet((long)nums[j] - t, (long)nums[j] + t + 1);
            if (!subSet.isEmpty()) return true;
            if (j >= k) set.remove((long)nums[j - k]);
            set.add((long)nums[j]);
        }
        return false;
    }
}
