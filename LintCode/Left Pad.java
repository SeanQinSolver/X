public class StringUtils {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        // Write your code here
        int len = originalStr.length();
        StringBuilder sb = new StringBuilder();
        if (size <= len) return originalStr;
        else {
            for (int i = 0; i < size - len; i++) {
                sb.append(" ");
            }
            sb.append(originalStr);
        }
        return sb.toString();
    }
    
    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here
        int len = originalStr.length();
        StringBuilder sb = new StringBuilder();
        if (size <= len) return originalStr;
        else {
            for (int i = 0; i < size - len; i++){
                sb.append(padChar);
            }
            sb.append(originalStr);
        }
        return sb.toString();
    }
}