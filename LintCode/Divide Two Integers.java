public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend  == 0) {
            return 0;
        }
        // -2147483648 / -1 = 2147483648 > 2147483647 溢出了，则现在直接计算。
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        //2147483647 / -1 = -2147483647
        if (dividend == Integer.MAX_VALUE && divisor == -1) {
            return Integer.MIN_VALUE + 1;
        }
        // 2147483647 / 1 =
        if (dividend == Integer.MAX_VALUE && divisor == 1) {
            return Integer.MAX_VALUE;
        }
        
        //若a为int最小值-214783648,转换为正数214783648大于int最大值214783647，则还是溢出而变成-214783648，所以要将a b都变成long型
        
        
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            //illegal shift
            System.out.println(shift + "  " + b);
            shift -= 1;
            a -= b << shift;
            result += 1 << shift;
        }
        return isNegative ? -result : result;
    }
}