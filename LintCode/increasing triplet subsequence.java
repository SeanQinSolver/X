public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int count1 = Integer.MAX_VALUE;
        int count2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if (count1 >= i) count1 = i;
            else if (count2 >= i && count1 < i) count2 = i;
            else return true;
        }
        return false;
    }
}
//思路不断缩小 count1, count2的间距
//设 count1为到目前为止的最小值 ，count2为到目前为止至少有一个数比count2小的最小的数。
//简单的说，上述的过程就是不断的缩小x1和x2，看看是否有第三个数 比x2大。

//如果出现第三个数 num > x2，则之前必定还有个数x 小于x2，就是说满足 x < x2 < num，就是说有答案啦。