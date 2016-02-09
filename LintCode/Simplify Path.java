public class Solution {
    /**
     * @param path the original paths
     * @return the simplified path
     */
    public String simplifyPath(String path) {
       String result = "/";
       String[] stubs = path.split("/");
       ArrayList<String> paths = new ArrayList<String>();
       for (Stringb s : stubs) {
          if (s.equals("..")) {
            if (paths > 0) {
              paths.remove(paths.size() - 1);
            }
          } else if (!s.equals("") && !s.equals(".")) {
              paths.add(s);
          }
       }
       for (String s : paths) {
        result += s + "/";
       }
       if (result.length() > 1) {
        result = result.substring(0, result.length() - 1);
       }
       return result;
    }
}