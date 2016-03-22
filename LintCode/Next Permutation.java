public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        if (nums == null) {
            return null;
        }
        int len = nums.length - 1;
        int k = -1;
        for (int i = len - 1;  i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        
        if (k == -1) {
            reverse(nums, 0, len);
            return nums;
        }
        
        while (k < len && nums[len] <= nums[k]) {
            len--;
        }
        
        swap(nums, k, len);
        //注意这里len只是一个pointer，在reverse的时候要重新传入数组长度
        reverse(nums, k + 1, nums.length - 1);
        return nums;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] num, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            swap(num, i, j);
        }
    }
}


// 从后往前寻找索引满足 a[k] < a[k + 1], 如果此条件不满足，则说明已遍历到最后一个。
// 从后往前遍历，找到第一个比a[k]大的数a[l], 即a[k] < a[l].
// 交换a[k]与a[l].
// 反转k + 1 ~ n之间的元素