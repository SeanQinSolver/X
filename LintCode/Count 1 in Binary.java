public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        int count = 0;
        int mask = 1;
        int temp = 0;
        while (mask != 0) {
            temp = num & mask;
            if (temp != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
};

//此题注意用mask不为零去判断循环条件