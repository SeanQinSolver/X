//http://blog.csdn.net/mebiuw/article/details/52449892
//recursion 
public class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n < k) return 0;
        int[] counter = new int[26];
        boolean valid[] = new boolean[26];
        char[] ss = s.toCharArray();
        for (int i = 0; i < n; i++) {
            counter[ss[i] - 'a']++;
        }
        
        boolean fullValid = true;
        
        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0 && counter[i] < k) {
                valid[i] = false;
                fullValid = false;
            }
            else {
                valid[i] = true;
            }
        }
        if (fullValid) return s.length();
        int max = 0;
        int lastStart = 0;
        //把不符合要求的断开
        for (int i = 0; i < n; i++) {
            if (valid[ss[i] - 'a'] == false) {
                max = Math.max(max, longestSubstring(s.substring(lastStart, i), k));
                lastStart = i + 1;
            }
        }
        max = Math.max(max, longestSubstring(s.substring(lastStart, n), k));
        return max;
    }
}