public class Solution {
    
    public void nextPermutation(int[] nums) {
        // find the last increase index
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        // find the first bigger one
        int biggerIndex = index + 1;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                biggerIndex = i;
                break;
            }
        }
        
        // swap them to make the permutation bigger
        swap(nums, index, biggerIndex);
        
        // reverse the last part
        reverse(nums, index + 1, nums.length - 1);
    }
    
    public void reverse(int[] nums, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
           swap(nums, i, j);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//此题关键是先找第一个nums[i] < nums[i+1]的。设leftIndex = i.
//若index到头了还为1,则把全部翻转
//再找第一个num[j] > num[leftIndex]，设置rightIndex = j
//交换rightIndex与leftIndex，然后再翻转leftIndex + 1到头