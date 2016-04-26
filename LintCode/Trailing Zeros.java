class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        if (n < 0) {
            return -1;
        }
        long count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
};

//Runtime: O(log5n)
//Space: O(1)

//此题想到任何合数(除1和本身以外，还能被其他数整除)可由质因数表示。
//那么10的质因数为2，5。2的个数肯定大于5的个数。所以求5的个数即可