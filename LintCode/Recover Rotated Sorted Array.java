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



//写法2

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        
        
        if (nums == null || nums.size() == 0) return;
        
        int k = -1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                k = i - 1;
            }
        }
        if (k == -1) return;
        if (k == 0) reverse(nums, 0, nums.size() - 1);
        
        reverse(nums, 0, k);
        reverse(nums, k + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }
    
    
    private void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            exch(nums, start, end);
            start++;
            end--;
        }
    }
    private void exch(ArrayList<Integer> nums, int start, int end) {
        int temp = nums.get(start);
        nums.set(start,nums.get(end));
        nums.set(end, temp);
    }
}

//此题的意思是先找到pivot点，即index - 1 > index的转折点。
//然后将左边rotate, 右边rotate，然后全部rotate