public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        String result = "/"；
        String[] group = path.split("/");
        ArrayList<String> paths = new ArrayList<String>();
        for (String s : group) {
            if (s.equals("..")) {
                //此排除/../的情况
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
                //这个地方排除空的字符串 e.x /home//foo/
            } else if (!s.equals("") && !s.equals(".")) {
                paths.add(s);
            }
        }
        
        for (String s : path) {
            result += s + "/";
        }
        if (result.length() > 1) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
    
}