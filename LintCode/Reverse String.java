public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) return s;
        if (s.length() == 1) return s;
        
        char[] array = s.toCharArray();
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            exch(array, start++, end--);
        }
        return String.valueOf(array);
    }
    private void exch(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}