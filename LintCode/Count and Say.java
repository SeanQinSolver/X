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