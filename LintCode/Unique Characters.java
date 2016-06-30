public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                return false;
            }
            set.add(str.charAt(i));
        }
        return true;
    }
}

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        if (str == null || str.length() == 0) return true;
        
        int[] array = new int[256];
        for (int i = 0; i < str.length(); i++) {
            array[str.charAt(i)]++;
            if (array[str.charAt(i)] > 1) return false;
        }
        return true;
    }
}