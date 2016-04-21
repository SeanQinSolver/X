public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    private String remove(String A, int pos) {
        return A.substring(0, pos) + A.substring(pos + 1);
    }
    
    public String DeleteDigits(String A, int k) {
        if (A.length() == k) {
            return "";
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < A.length(); j++) {
                //
                if (j == A.length() - 1 || A.charAt(j + 1) < A.charAt(j)) {
                    A = remove(A, j);
                    break;
                }
            }
        }
        
        int index = 0;
        while (index < A.length() - 1 && A.charAt(index) == '0') {
            index++;
        }
        return A.substring(index);
    }
}


//此题用直接遍历的方法，遍历k次，当j+1 < j去掉j位
//再注意在j == A.length - 1时的边界情况，123456789 k = 1。此时应去掉9，则在j == A.length() - 1
//放在前面


//写法2

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    private String remove(String A, int k) {
        return A.substring(0, k) + A.substring(k + 1);
    }
    
    public String DeleteDigits(String A, int k) {
        if (A.length() == k) {
            return "";
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < A.length(); j++) {
                if (j == A.length() - 1 || A.charAt(j) > A.charAt(j + 1)) {
                    A = remove(A, j);
                    break;
                }
            }
        }
        
        int index = 0;
        while (index < A.length()) {
            if (A.charAt(index) == '0') {
                index++;
            } else {
                break;
            }
        }
        return A.substring(index);
        
        
    }
}