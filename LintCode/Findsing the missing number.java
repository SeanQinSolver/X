public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        int result = 0;
        //Arrays.sort(nums);
        int index = nums.length;
        if (index == 1 && nums[0] == 0) {
            return 1;
        } 
        if (index == 1 && nums[0] == 1) {
            return 0;
        }
        int values = 0;
        for (int i = 0; i < nums.length; i++) {
            index += i;
            values += nums[i];
        }
        result = index - values;
        return result;
    }
}