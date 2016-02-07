public class Solution {
    
    public int lengthOfLastWord(String s) {
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && length == 0) {
                continue;
            } else if (s.charAt(i) == ' ') {
                break;
            } else {
                length++;
            }
        }
        return length;
    }
}