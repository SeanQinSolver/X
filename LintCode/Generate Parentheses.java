//Method1
public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }
    
    public void helper(ArrayList<String> result, String paren, int left, int right) {
        if (left < 0 || right < left) {
            return;
        }
        if (left == 0 && right ==0) {
            result.add(paren);
            return;
        }
        if (left > 0) {
            helper(result, paren + "(", left - 1, right);
        }
        if (right > 0) {
            helper(result, paren + ")", left, right - 1);
        }
    }
}
//Method2
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        HashSet<String> set = helper(n);
        Iterator i = set.iterator();
        while (i.hasNext()) {
            list.add((String)(i.next()));
        }
        return list;
    }
    public HashSet<String> helper(int n) {
        HashSet<String> set = new HashSet<String>();
        if (n == 0) {
            set.add("");
        } else {
            HashSet<String> prev = helper(n - 1);
            for (String str : prev) {
                set.add("()" + str);
                set.add(str + "()");
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insert(str, i);
                        set.add(s);
                    }
                }
                
            }
        }
        return set;
    }
    public String insert(String str, int index) {
        String left = str.substring(0, index + 1);
        String right = str.substring(index + 1, str.length());
        return left + "()" + right;
    }
}