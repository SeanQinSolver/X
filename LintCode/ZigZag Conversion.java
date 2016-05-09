public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0){
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int size = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int temp = j + size - 2 * i;
                    if (temp < s.length()) {
                        sb.append(s.charAt(temp));
                    }
                }
            }
        }
        return sb.toString();
    }
}