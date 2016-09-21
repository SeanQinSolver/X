//manacher n2

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return new String();
        }
        char[] array = s.toCharArray();
        
        int left = 0, right = 0;
        int maxLen = 0;
        
        for (int i = 0; i < s.length();) {
            int i1 = getFarestSameElementIndex(array, i);
            int bigLen = getLen(s, i, i1);
            
            int index1 = i - bigLen;
            int index2 = i1 + bigLen;
            
            int len = index2 - index1;
            
            if (len > maxLen) {
                maxLen = len;
                left = index1;
                right = index2;
            }
            i = i1 + 1;
        }
        return s.substring(left, right + 1);
        
    }
    
    
    private int getLen(String s, int left, int right) {
        int count = 0;
        while (left > 0 && right < s.length() - 1 && s.charAt(--left) == s.charAt(++right)) {
            count++;
        }
        return count;
    }
    
    private int getFarestSameElementIndex(char[] arr, int index){
        for(int i = index+1;i<arr.length;i++){
            if(arr[i]!=arr[index]){
                return i-1;
            }
        }
        return arr.length-1;
    }
}

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

//写法2

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return new String();
        }
        
        int longest = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isValid(temp) && temp.length() > longest) {
                    longest = temp.length();
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right);
    }
    
    private boolean isValid(String s) {
        
        char[] array = s.toCharArray();
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start++] != array[end--]) {
                return false;
            }
        }
        return true;
    }
}


//dp

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) return s;
        
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int maxLen = 1;
        
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                isPalindrome[i - 1][i] = true;
                maxLen = 2;
                start = i - 1;
            }
        }
        
        
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i + len <= s.length(); i++) {
                int j = i + len - 1;
                if (s.charAt(j) == s.charAt(i) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    if (maxLen < len) {
                        //System.out.println(maxLen);
                        maxLen = Math.max(maxLen, len);
                        start = i;
                    }
                    
                }
            }
        }
        //System.out.println(maxLen);
        return s.substring(start, start + maxLen);
    }