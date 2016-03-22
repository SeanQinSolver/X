public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }
        
        int index = 1;
        while (index < nums.size()) {
            if (nums.get(index - 1) > nums.get(index)) {
                break;
            }
            index++;
        }
        rotate(nums, 0, index - 1);
        rotate(nums, index, nums.size() - 1);
        rotate(nums, 0, nums.size() - 1);
    }
    
    private void rotate(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}

//此题的意思是先找到pivot点，即index - 1 > index的转折点。
//然后将左边rotate, 右边rotate，然后全部rotate