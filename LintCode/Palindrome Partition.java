public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        helper(rst, path, s, 0);
        return rst;
    }
    
    private void helper(List<List<String>> rst, List<String> path, String s, int start) {
        if (start == s.length()) {
            rst.add(new ArrayList<String>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            if (isValid(temp)) {
                path.add(temp);
                helper(rst, path, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    
    private boolean isValid(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}