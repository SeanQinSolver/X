class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    // an次方%b = (an/2次方%b * an/2次方%b) % b
    public int fastPower(int a, int b, int n) {
        if (n == 1) {
            return a % b;
        } else if (n == 0) {
            //注意此时b == 1时得 1 % b == 0所以只能用1 % b而不直接return 1
            return 1 % b;
        } else if (n < 0) {
            return -1;
        }
        
        long result = fastPower(a, b, n / 2);
        result = (result * result) % b;
        if (n % 2 == 1) {
            result = (result * a) % b;
        }
        return result;
    }
};

// a10%3 equals (a5%3 * a5%3) % 3;