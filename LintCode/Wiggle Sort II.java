public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        Arrays.sort(nums);
        
        int n = nums.length;
        
        
        int[] temp = new int[n];
        int left = (n - 1) / 2;
        int right = n - 1;
        
        for (int i = 0; i < n; i++) {
            //temp[i] = ((i & 1) == 0) ? nums[k--] : nums[j--];
            if ((i & 1) == 0) {
                temp[i] = nums[left--];
            } else {
                temp[i] = nums[right--];
            }
        }
        
        System.arraycopy(temp, 0, nums, 0, n);
    }
}
//o(n) and extra o(n) space
//写法2

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        Arrays.sort(nums);
        
        int n = nums.length;
        
        int[] temp = new int[n];
        System.arraycopy(nums, 0, temp, 0, n);
        int left = (n - 1) / 2;
        int right = n - 1;
        
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
    }
}
//o(n) and extra o(n) space
