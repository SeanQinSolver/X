opublic class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int even = nums.length;
        for (int i = 0; i < even; i++) {
            if (nums[i] % 2 == 0) {
                int tmp = nums[i];
                nums[i] = nums[--even];
                nums[even] = tmp;
                i--;
            }
        }
    }
}

//此题注意for循环的时候不能以nums.length作为右边界，要以index为右边界

//写法2

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = nums.length - 1;
        for (int i = 0; i <= index; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                
                nums[index] = temp;
                index--;
                i--;
            }
        }
    }
}

//此题注意for循环的时候不能以nums.length作为右边界，要以index为右边界


//method2

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        for (int i = 0, j = nums.length - 1; i < j;) {
            while (nums[i] % 2 != 0) i++;
            while (nums[j] % 2 == 0) j--;
            if (i >= j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}