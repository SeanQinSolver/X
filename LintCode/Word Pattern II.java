public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        
        return isMatch(str, 0, pattern, 0, map, set);
    }
    
    private boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;
        
        char c = pat.charAt(j);
        //if map has already the key, then check the value whether begin with s.
        if (map.containsKey(c)) {
            String s = map.get(c);
            
            if (!str.startsWith(s, i)) {
                return false;
            }
            return isMatch(str, i + s.length(), pat, j + 1, map, set);
        }
        //map没有这个key
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);
            
            if (set.contains(p)) continue;
            
            map.put(c, p);
            set.add(p);
            
            if (isMatch(str, k + 1, pat, j + 1, map, set)) {
                return true;
            }
            map.remove(c);
            set.remove(p);
        }
        return false;
    }
}