public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        helper(result, list, s, 0);
        return result;
    }
    
    private void helper(ArrayList<String> result, ArrayList<String> list, String s, int start) {
        if (list.size() == 4) {
            if (start != s.length()) {
                System.out.println("hah")
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String tmp : list) {
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }
        
        for (int i = start; i <= start + 3 && i < s.length(); i++) {
            String tmp = s.substring(start, i + 1);
            if (isValid(tmp)) {
                list.add(tmp);
                helper(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        //以零开头的必为零
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}