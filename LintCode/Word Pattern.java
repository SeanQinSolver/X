//method1 two hashmap
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        
        String[] array = str.split("\\W");
        //System.out.println(array.length + "  " + pattern.length());
        if (array.length != pattern.length()) return false;
        
        for (int i = 0; i < pattern.length(); i++) {
            String s = array[i];
            char c = pattern.charAt(i);
            if (map1.containsKey(c)) {
                if (!map1.get(c).equals(s)) return false;
            }
            if (map2.containsKey(s)) {
                if (map2.get(s) != c) return false;
            }
            map1.put(c, s);
            map2.put(s, c);
        }
        return true;
    }
}

//method2 1hashmap with set

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        
        String[] array = str.split("\\W");
        
        if (array.length != pattern.length()) return false;
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = array[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(s)) return false;
            } else {
                if (set.contains(s)) {
                    //System.out.println(s);
                    return false;
                }
                set.add(s);
                map.put(c, s);
            }
        }
        return true;
    }
}