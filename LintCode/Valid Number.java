public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        int i = 0;
        int e = s.length() - 1;
        while (i <= e && Character.isWhitespace(s.charAt(i))) i++;
        if (i > e) return false;
        while (e >= i && Character.isWhitespace(s.charAt(e))) e--;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        while (i <= e) {
            if (Character.isDigit(s.charAt(i))) {
                num = true;
            } else if (s.charAt(i) == 'e') {
                if (exp || !num) return false;
                exp = true;
            } else if (s.charAt(i) == '.') {
                if (dot) return false;
                dot = true;
            } else {
                return false;
            }
            i++;
        }
        return num;
    }
}