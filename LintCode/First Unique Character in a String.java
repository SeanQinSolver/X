public class Solution {
    public int firstUniqChar(String s) {
        
        if (s == null || s.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

public class Solution {
    public int firstUniqChar(String s) {
        
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int temp = (int)s.charAt(i) - 97;
            result[temp]++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            int temp = (int)s.charAt(i) - 97;
            if (result[temp] == 1) {
                return i;
            }
        }
        return -1;
    }
}