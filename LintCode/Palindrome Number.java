public class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (s.length() == 1) return true;
        return isValid(s);
    }
    
    private boolean isValid(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}