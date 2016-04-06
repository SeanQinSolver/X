public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }
        int len = str.length;
        offset %= len;
        reverse(str, len - offset, len - 1);
        reverse(str, 0, len - offset - 1);
        reverse(str, 0, len - 1);
        
        
    }
    private void reverse(char[] num, int i, int j) {
        while (i < j) {
            char temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
    }
}

//此题思路先翻转右边，再翻转左边。再整体翻转