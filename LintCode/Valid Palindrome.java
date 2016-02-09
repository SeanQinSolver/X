public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
       if (s == null || s.length() == 0) {
           return true;
       }
       int start = 0;
       int end = s.length() - 1;
        
        while (start < end) {
            while (start < end && !isValid(s.charAt(start))) {
                start++;
            }
            //空字符串只有标点“,..,”
            if (start == end) {
                return true;
            }
            while (start < end && !isValid(s.charAt(end))) {
                end--;
            }
            if (Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return end <= start;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}