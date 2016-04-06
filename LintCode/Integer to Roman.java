public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        if (n == 0) {
            return new String("");
        }
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int times = n / nums[count];
            n -= times * nums[count];
            while (times > 0) {
                sb.append(symbol[count]);
                times--;
            }
            count++;
        }
        return sb.toString();
    }
}