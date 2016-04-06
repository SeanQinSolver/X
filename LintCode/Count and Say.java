public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        String init = "1";
        
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] oldChars = init.toCharArray();
            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ( (i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
            }
            init = sb.toString();
        }
        return init;
    }
}


//写法2

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        if (n <= 0) return null;
        
        String s = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            char[] array = s.toCharArray();
            for (int m = 0; m < array.length; m++) {
                if (m + 1 < array.length && array[m] == array[m + 1]) {
                    count++;
                } else {
                    sb.append(count + "" + array[m]);
                    count = 1;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}