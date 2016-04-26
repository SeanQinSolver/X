public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (B == null || B.length() == 0) return true;
        if (A == null || A.length() == 0) return false;
        
        int[] counts = new int[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = 0;
        }
        for (int i = 0; i < A.length(); i++) {
            counts[A.charAt(i) - 'A']++;
        }
        for (int i = 0; i < B.length(); i++) {
            counts[B.charAt(i) - 'A']--;
            if (counts[B.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }
}

//写法2

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (A == null && B != null) return false;
        if (A != null && B == null) return true;
        
        int[] count = new int[26];
        
        for (int i = 0; i < A.length(); i++) {
            count[A.charAt(i) - 'A']++;
        }
        
        for (int i = 0; i < B.length(); i++) {
            count[B.charAt(i) - 'A']--;
            if (count[B.charAt(i) - 'A'] < 0) return false;
        }
        return true;
    }
}