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
            return  1 % b;
        } else if (n < 0) {
            return -1;
        }
        
        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;
        //如果a是奇数个数的话
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        
        return (int)product;
        
    }
};