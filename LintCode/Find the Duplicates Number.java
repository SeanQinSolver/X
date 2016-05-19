//method1 binary search NlogN
public class Solution {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            //O(N)
            for (int x : nums) {
                if (x <= mid) count++;
            }
            //O(logN)
            if (count > mid) {
                right = mid - 1;
            }
            if (count <= mid) {
                left = mid + 1;
            }
        }
        return left;
    }
}

//method2 快慢指针
//类似quick-find题目
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        //或者do while循环
        
        int res = 0;
        
        while (res != slow) {
            res = nums[res];
            slow = nums[slow];
        }
        return slow;
    }
}