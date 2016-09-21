
/* The read4 API is defined in the parent class Reader4.
 int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) return 0;
        int index = 0;
        while (true) {
            char[] readBuff = new char[4];
            int len = read4(readBuff);
            //o(n)
            for (int m = 0; m < len; m++) {
                buf[index++] = readBuff[m];
                if (index == n) {
                    return index;
                }
            }
            if (len < 4) break;
        }
        return index;
    }
}