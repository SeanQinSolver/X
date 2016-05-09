https://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/comment-page-1/#comment-122


public class Solution {
    public String multiply(String num1, String num2) {
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int[] array = new int[num1.length() + num2.length()];
        
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                array[i + j] += a * b;
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " " + array[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            int digit = array[i] % 10;
            int carry = array[i] / 10;
            sb.insert(0, digit);
            if (i + 1 < array.length) {
                array[i + 1] += carry;
            }
        }
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}