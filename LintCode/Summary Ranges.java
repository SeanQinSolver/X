public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<String>();
        int i = 0;
        int len = nums.length;
        while (i < len) {
            int j = 1;
            while (i + j < len && nums[i + j] - nums[i] == j) j++;
            if (j == 1) {
                rst.add(String.valueOf(nums[i]));
            } else {
                rst.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[i + j - 1]));
            }
            i += j;
        }
        return rst;
    }
}
//思路就是遍历数组，有连续的直接加j，知道没有连续的那么rst.add(nums[i] -> nums[i+j-1]);
//如果一个数没有连续的那么直接存这个数
