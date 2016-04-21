public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // int maxlen = 0;
        // int xlen = A.length();
        // int ylen = B.length();
        // for (int i = 0; i < xlen; i++) {
        //     for (int j = 0; j < ylen; j++) {
        //         //Everytime the length should equal zero
        //         int len = 0;
        //         while (i + len < xlen && j + len < ylen && A.
        //         charAt(i + len) == B.charAt(j+len)) {
        //             len++;
        //             if (len > maxlen) {
        //                 maxlen = len;
        //             }
        //         }
        //     }
        // }
        // return maxlen;
        
        
        int maxLen = 0;
        int xLen = A.length();
        int yLen = B.length();
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                int len = 0;
                while (i + len < xLen && j + len < yLen && A.charAt(i + len) == B.charAt(j + len)) {
                    len++;
                }
                maxLen = len > maxLen ? len : maxLen;
            }
        }
        return maxLen;
    }
}