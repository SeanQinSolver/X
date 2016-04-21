public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        
        int carries = 1;
        for (int i = digits.length - 1; i >= 0 && carries > 0; i--) {
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        if (carries == 0) {
            return digits;
        }
        //若上部没有进位的话这步就表示第一位总是进了位,长度就加了1
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 0; i < result.length - 1; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}