//method1
public class Solution {
    public int lengthLongestPath(String input) {
        int result = 0;
        String[] array = input.split("\n");
        int[] lens = new int[array.length + 1];
        
        for (String str : array) {
            String[] array1 = str.split("\t");
            String tmp = array1[array1.length - 1];
            int len = lens[array1.length - 1] + tmp.length() + 1;
            if (str.contains(".")) {
                result = Math.max(result, len - 1);
            } else {
                lens[array1.length] = len;
            }
        }
        return result;
    }
}