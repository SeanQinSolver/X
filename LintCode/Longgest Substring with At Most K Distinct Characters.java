
//o(1)space, o(n)runntime
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        int[] memo = new int[256];
        Arrays.fill(memo, -1);
        int count = 0;
        int leftIndex = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count < k && memo[c] == -1) {
                count++;
            } else if (memo[c] == -1) {
                leftIndex = updateIndex(s, memo, i, leftIndex);
            }
            memo[c] = i;
            maxLen = Math.max(i - leftIndex + 1, maxLen);
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
    private int updateIndex(String s, int[] memo, int curr, int leftIndex) {
        for (int i = leftIndex; i < curr; i++) {
            char temp = s.charAt(i);
            if (memo[temp] == i) {
                memo[temp] = -1;
                //传递
                return i + 1;
            }
        }
        return curr;
    }
}