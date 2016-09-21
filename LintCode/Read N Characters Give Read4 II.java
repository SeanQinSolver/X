/* The read4 API is defined in the parent class Reader4.
 int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    char[] buffMid = new char[4];
    int prevIndex = 0;
    int preSize = 0;
    
    public int read(char[] buf, int n) {
        int index = 0;
        
        while (index < n) {
            if (prevIndex < preSize) {
                buf[index++] = buffMid[prevIndex++];
            } else {
                preSize = read4(buffMid);
                prevIndex = 0;
                if (preSize == 0) {
                    break;
                }
            }
        }
        return index;
    }
}