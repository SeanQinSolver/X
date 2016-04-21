public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        int rst = 0;
        int rst_next = 0;
        while (n != 0) {
            rst_next = rst * 10 + n % 10;
            n = n / 10;
            // 超过int极限
            if (rst_next / 10 != rst) {
                rst = 0;
                break;
            }
            rst = rst_next;
        }
        return rst;
    }
}

//此题注意Overflow问题，判断是rst_next / 10 != rst