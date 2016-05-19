public class Solution {
    public String reverseVowels(String s) {
        String check = new String("aeiouAEIOU");
        if (s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!check.contains(String.valueOf(array[i]))) {
                i++;
                continue;
            }
            if (!check.contains(String.valueOf(array[j]))) {
                j--;
                continue;
            }
            
            char t = array[i];
            array[i] = array[j];
            array[j] = t;
            i++;
            j--;
        }
        return String.valueOf(array);
    }
}