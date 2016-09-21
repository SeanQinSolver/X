//o(n) space, o(n) runtime
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int leftIndex = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            
            while (map.size() > 2) {
                char temp = s.charAt(leftIndex);
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) == 0) {
                    map.remove(temp);
                }
                leftIndex++;
            }
            maxLen = Math.max(maxLen, i - leftIndex + 1);
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}

//O(1) space, O(n) runtime
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] memo = new int[256];
        Arrays.fill(memo, -1);
        int count = 0;
        int leftIndex = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count < 2 && memo[c] == -1) {
                count++;
            } else if (memo[c] == -1) {
                leftIndex = udpateIndex(leftIndex, i, memo, s);
            }
            memo[c] = i;
            maxLen = Math.max(i - leftIndex + 1, maxLen);
            
        }
        return maxLen;
    }
    
    private int udpateIndex(int leftIndex, int currIndex, int[] memo, String s) {
        for (int i = leftIndex; i < currIndex; i++) {
            char c = s.charAt(i);
            if (memo[c] == i) {
                memo[c] = -1;
                return i + 1;
            }
        }
        return currIndex;
    }
}

