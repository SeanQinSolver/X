public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n *= -1;
        }
        int l = n / 2;
        int k = n - l * 2;
        double result1 = myPow(x, l);
        double result2 = myPow(x, k);
        
        
        if (!isNeg) {
            return Math.pow(result1, 2) * result2;
        } else {
            return 1 / (Math.pow(result1, 2) * result2);
        }
        
    }
}

//此题为recursion求出具体答案