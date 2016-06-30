class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        if (a == b) {
            return 0;
        }
        int temp = a ^ b;
        int count = 0;
        int index = 32;
        //因是integer，所以要比较32位
        while (index > 0) {
            count += temp & 1;
            temp = temp >> 1;
            index--;
        }
        return count;
    }
};


//写法2

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        if (a == b) return 0;
        int mask = a ^ b;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += mask & 1;
            mask >>= 1;
        }
        return count;
    }
};