//o(n) space, O(n) time
public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        HashSet<Character> set = new HashSet<Character>();
        int leftBound = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (leftBound < i && s.charAt(leftBound) != s.charAt(i)) {
                    set.remove(s.charAt(leftBound));
                    leftBound++;
                }
                leftBound++;
            } else {
                set.add(s.charAt(i));
                len = Math.max(len, i - leftBound + 1);
            }
        }
        return len;
    }
}

//o(1) space, o(n) time
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] array = new int[256];
        Arrays.fill(array, -1);
        int leftIndex = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i)] != -1) {
                //System.out.println(s.charAt(i));
                leftIndex = updateLeftIndex(leftIndex, i, array, s);
                //System.out.println("leftIndex:  " + leftIndex);
            }
            array[s.charAt(i)] = i;
            //System.out.println(i + "  " + leftIndex + "   ");
            maxLen = Math.max(maxLen, i - leftIndex + 1);
            
        }
        return maxLen;
    }
    private int updateLeftIndex(int leftIndex, int current, int[] array, String s) {
        for (int i = leftIndex; i < current; i++) {
            if (array[s.charAt(i)] == i && s.charAt(i) == s.charAt(current)) {
                //array[s.charAt(i)] = -1;
                return i + 1;
            }
            array[s.charAt(i)] = -1;
        }
        return current;
    }
}
//o(1)
//int[256]
//此题重点就是另外一个指针删除当有set里面存在的时候删除前面的直到达到相等元素的后一个再开始