method1

public class Solution {
    /**
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     */
    public boolean search(int[] A, int target) {
        // write your code here
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}

//method2

public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[start]) {
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (nums[start] < nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                start++;
            }
        }
        
        if (nums[start] == target) {
            return true;
        } else if (nums[end] == target){
            return true;
        } else {
            return false;
        }
    }
}