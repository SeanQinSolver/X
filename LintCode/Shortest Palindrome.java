//BRUTAL 1
//o(N2)
public class Solution {
    public String shortestPalindrome(String s) {
        
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {//找到第一个使他不回文的位置
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        
        if (j == s.length()) return s; //本身是回文
        
        String suffix = s.substring(j); // 后缀不能够匹配的字符串
        
        String prefix = new StringBuilder(suffix).reverse().toString(); // 前面补充prefix让他和suffix回文匹配
        
        String mid = shortestPalindrome(s.substring(0, j)); //递归调用找 [0,j]要最少可以补充多少个字符让他回文
        
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(mid);
        sb.append(suffix);
        return sb.toString();
    }
}

//BRUTAL 2 leetcode TLE
O(N2)

public class Solution {
    public String shortestPalindrome(String s) {
        
        int len = s.length();
        int move = len;
        StringBuilder sb = new StringBuilder();
        
        while (move > 1) {
            if (isPalindrome(s.substring(move, len))) {
                sb = sb.append(s.substring(move, len)).reverse();
            }
            move--;
        }
        
        if (sb.length() == 0) {
            sb = sb.append(s.substring(move, len)).reverse();
        }
        return sb.append(s).toString();
    }
    
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}