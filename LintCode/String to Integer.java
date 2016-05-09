public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        
        str = str.trim();
        
        int index = 0;
        
        char head = str.charAt(0);
        boolean flag = true;
        
        if (head == '+') {
            index++;
        } else if (head == '-'){
            index++;
            flag = false;
        }
        
        //System.out.println(index);
        double result = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            result = result * 10 + str.charAt(index) - '0';
            index++;
        }
        
        if (!flag) {
            result = -result;
        }
        
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        return (int)result;
    }
}

//此题注意用double来存result,double的范围可以超过Integer的范围
