public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    // private boolean isPalindrome (String s, int start, int end) {
    //     for (int i = start, j = end; i < j; i++, j--) {
    //         if (s.charAt(i) != s.charAt(j)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    //o(n2)
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        //区间为0的为TRUE
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        //区间为1的判断
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        //从区间为2的开始判断是否为回文串
        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length] = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        return iPalindrome;
    }
    
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        //preparation
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        //initialize 至少要切多少刀
        int[] f = new int[s.length() + 1]; //保留第0个位置
        for (int i = 0; i <= s.length(); i++) {
            f[i] = i - 1;
        }
        
        //main
        //o(n2)，判断j+1与i之间是否是动态规划
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i-1]) {
                    f[i] = Math.min(f[i],  f[j] + 1);
                }
            }
        }
        return f[s.length()];
    }
}

//写法2

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    
    //o(n2)
    private boolean[][] getIsPalindrome(String s) {
        int len = s.length();
        boolean[][] mat = new boolean[len][len];
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (j == i) {
                    mat[i][j] = true;
                } else if (j == i + 1) {
                    mat[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    mat[i][j] = (s.charAt(i) == s.charAt(j)) && mat[i + 1][j - 1];
                }
            }
        }
        
        return mat;
    }
    
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // preparation
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        int len = s.length();
        
        // initialize
        int[] f = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            f[i] = i - 1;
        }
        
        // main
        for (int i = 1; i <= len; i++) {
            //f[i] = Integer.MAX_VALUE; // or f[i] = i
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        
        return f[len];
    }
}