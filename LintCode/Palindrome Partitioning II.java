//dp两层放一起

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    
    //o(n2)
    
    
    public int minCut(String s) {
        
        int min = 0;
        int len = s.length();
        if (s == null || s.length() == 0) return min
            ;
        boolean[][] matrix = new boolean[len][len];
        //cut[i]代表i位到末尾的距离
        int[] cut = new int[len + 1];
        
        for (int i = 0; i < len; i++) {
            cut[i] = len - i;
        }
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if ((s.charAt(i) == s.charAt(j) && (j - i < 2)) || (s.charAt(i) == s.charAt(j) && matrix[i + 1][j - 1])) {
                    matrix[i][j] = true;
                    cut[i] = Math.min(cut[i], cut[j + 1] + 1);
                }
            }
        }
        //把多余加的那个对于第len位置的切割去掉，即为最终结果。
        min = cut[0] - 1;
        return min;
    }
    
}
//http://www.cnblogs.com/springfor/p/3891896.html
// 这道题需要用动态规划做，如果用I的DFS的方法做会TLE。



//  首先设置dp变量 cuts[len+1]。cuts[i]表示从第i位置到第len位置（包含，即[i, len])的切割数（第len位置为空）。

//  初始时，是len-i。比如给的例子aab，cuts[0]=3，就是最坏情况每一个字符都得切割：a|a|b|' '。cuts[1] = 2, 即从i=1位置开始，a|b|' '。

//  cuts[2] = 1 b|' '。cuts[3]=0,即第len位置，为空字符，不需要切割。



//  上面的这个cuts数组是用来帮助算最小cuts的。



//  还需要一个dp二维数组matrixs[i][j]表示字符串[i,j]从第i个位置（包含）到第j个位置（包含） 是否是回文。

//  如何判断字符串[i,j]是不是回文？

//  1. matrixs[i+1][j-1]是回文且 s.charAt(i) == s.charAt(j)。

//  2. i==j（i，j是用一个字符）

//  3. j=i+1（i，j相邻）且s.charAt(i) == s.charAt(j)



//  当字符串[i,j]是回文后，说明从第i个位置到字符串第len位置的最小cut数可以被更新了，

//  那么就是从j+1位置开始到第len位置的最小cut数加上[i,j]|[j+1,len - 1]中间的这一cut。

//  即，Math.min(cuts[i], cuts[j+1]+1)

//  最后返回cuts[0]-1。把多余加的那个对于第len位置的切割去掉，即为最终结果。

//dp
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
        //length为区间
        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length] = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        return isPalindrome;
    }
    
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        //preparation
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        //initialize 至少要切多少刀就是全部切成单个字符串
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