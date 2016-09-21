//method1 dp better 写法
public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                match[0][i] = true;
            } else {
                break;
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    match[i][j] = match[i - 1][j] || match[i][j - 1];
                } else if (p.charAt(j - 1) == '?') {
                    match[i][j] = match[i - 1][j - 1];
                } else {
                    match[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && match[i - 1][j - 1];
                }
            }
        }
        return match[m][n];
    }
}



//method 1 dp

public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        
        int lens = s.length();
        int lenp = p.length();
        
        boolean[][] dp = new boolean[lens + 1][lenp + 1];
        
        boolean flag = false;
        
        for (int i = 0; i <= lens; i++) {
            //flag 可以去掉，这里事贪心的思维
            flag = false;
            for (int j = 0; j <= lenp; j++) {
                //s and p both empty
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    flag = true;
                    continue;
                }
                //p is empty
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                
                if (i == 0) {
                    //s is empty but p is not empty
                    dp[i][j] = dp[i][j - 1] && p.charAt(j - 1) == '*';
                } else {
                    //s and p both is not empty
                    //匹配一个或者多个
                    dp[i][j] = (compare(s.charAt(i - 1), p.charAt(j - 1)) && dp[i - 1][j - 1]) || (p.charAt(j - 1) == '*' && (dp[i][j - 1] || dp[i - 1][j]));
                }
                //flag 可以去掉，这里事贪心的思维
                if (dp[i][j]) flag = true;
                
                //greedy already reach at Lenp and j - 1 is *
                if (dp[i][j] && p.charAt(j - 1) == '*' && j == lenp) return true;
            }
            //flag 可以去掉，这里事贪心的思维
            if (!flag) return false;
        }
        return dp[lens][lenp];
    }
    
    private boolean compare(char c1, char c2) {
        return c2 ==  '?' || c1 == c2;
    }
}

//method2 2 pointers

public class Solution{
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int lenS = s.length();
        int lenP = p.length();
        
        int indexS = 0;
        int indexP = 0;
        
        int preS = 0;
        int preP = 0;
        
        boolean back = false;
        while (indexS < lenS) {
            if (indexP < lenP && compare(s.charAt(indexS), p.charAt(indexP))) {
                indexS++;
                indexP++;
            } else if (indexP < lenP && p.charAt(indexP) == '*') {
                while (indexP < lenP && p.charAt(indexP) == '*') {
                    indexP++;
                }
                
                if (indexP == lenP) return true;
                
                back = true;
                preS = indexS;
                preP = indexP;
            } else if (back) {
                indexS = ++preS;
                indexP = preP;
            } else {
                return false;
            }
        }
        //跳过末尾所有的'*'
        while (indexP < lenP && p.charAt(indexP) == '*') indexP++;
        
        if (indexS == lenS && indexP == lenP) return true;
        
        return false;
    }
    
    private boolean compare(char c1, char c2) {
        return c2 == '?' || c1 == c2;
    }
}

//2 point2 metho3

public class Solution{
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return true;
        
        int lenS = s.length();
        int lenP = p.length();
        
        int indexS = 0;
        int indexP = 0;
        
        int preP = -1;
        int preS = -1;
        
        while (indexS < lenS) {
            if (indexP < lenP && compare(s.charAt(indexS), p.charAt(indexP))) {
                indexP++;
                indexS++;
            } else if (indexP < lenP && p.charAt(indexP) == '*') {
                preS = indexS;
                preP = indexP;
                indexP++;
            } else if (preP != -1) {
                indexP = preP;
                indexP++;
                
                preS++;
                indexS = preS;
            } else {
                return false;
            }
        }
        
        while (indexP < lenP) {
            if (p.charAt(indexP) != '*') {
                return false;
            }
            indexP++;
        }
        return true;
    }
    
    private boolean compare(char c1, char c2) {
        return c2 == '?' || c1 == c2;
    }
}
//dfs

public boolean isMatch(String s, String p) {
   if (p.isEmpty()) {
        return s.isEmpty();
    }

    if (p.charAt(0) == '?') {
        return !s.isEmpty() && isMatch(s.substring(1), p.substring(1));
    } else if (p.charAt(0) == '*') {
        return isMatch(s, p.substring(1)) || !s.isEmpty() && isMatch(s.substring(1), p);
    } else {
        return !s.isEmpty() && s.charAt(0) == p.charAt(0) && isMatch(s.substring(1), p.substring(1));
    }
}