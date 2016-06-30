opublic class Solution {
    
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


//method2

public class Solution {
    
    public int lengthOfLastWord(String s) {
        //if (s == null || s.length == 0) return 0;
        String[] array = s.split("\\W");
        return array[array.length - 1].length();
    }
}