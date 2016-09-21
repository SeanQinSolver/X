public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) return new ArrayList<String>();
        
        List<String> rst = new ArrayList<String>();
        List<String> path = new ArrayList<String>();
        
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (dp[j + 1] && dict.contains(s.substring(i, j + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        dfs(dict, rst, path, dp, 0, s);
        return rst;
    }
    
    private void dfs(Set<String> dict, List<String> rst, List<String> path, boolean[] dp, int index, String s) {
        if (!dp[index]) {
            return;
        }
        
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String str : path) {
                sb.append(str);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            rst.add(sb.toString());
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            String prefix = s.substring(index, i + 1);
            if (dict.contains(prefix)) {
                path.add(prefix);
                dfs(dict, rst, path, dp, i + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }
}