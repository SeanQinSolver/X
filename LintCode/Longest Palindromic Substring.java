//Method1 n2
public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return new String("");
        }
        int maxLength = Integer.MIN_VALUE;
        String result = null;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String curr = s.substring(i, j);
                int tempLength = j - i;
                if (tempLength > maxLength && isPalindrome(curr)) {
                    result = curr;
                    maxLength = tempLength;
                }
            }
        }
        return result;
    }
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}