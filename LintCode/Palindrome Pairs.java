//on3 does not pass
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    String tmp = words[i] + words[j];
                    if (isPalindrome(tmp)) {
                        result.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

//n2 * k pass

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words){
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (words[i].length() == words[j].length()) {
                    if (isPalindrome(words[i], words[j])) {
                        rst.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                        rst.add(new ArrayList<Integer>(Arrays.asList(j, i)));
                    }
                } else {
                    if (isPalindrome(words[i], words[j])) {
                        rst.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                    }
                    if (isPalindrome(words[j], words[i])) {
                        rst.add(new ArrayList<Integer>(Arrays.asList(j, i)));
                    }
                }
            }
        }
        return rst;
    }
    
    private boolean isPalindrome(String s1, String s2) {
        int len = s1.length() + s2.length();
        int rightLen = len - s2.length();
        int leftLen = s1.length();
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            
            char left = i >= leftLen ? s2.charAt(i - leftLen) : s1.charAt(i);
            char right = j < rightLen ? s1.charAt(j) : s2.charAt(j - rightLen);
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}


//o(k * n^2)

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words){
        
        List<List<Integer>> pairs = new LinkedList<>();
        if (words == null) return pairs;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++ i) map.put(words[i], i);
        
        for (int i = 0; i < words.length; ++ i) {
            int l = 0, r = 0;
            while (l <= r) {
                String s = words[i].substring(l, r);
                //System.out.println(s + "       sss");
                Integer j = map.get(new StringBuilder(s).reverse().toString());
                // System.out.println("J:   " + j);
                //System.out.println("l: " + l + " r: " + r);
                // System.out.println(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l));
                if (j != null && i != j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l))) {
                    //System.out.println(l);
                    //System.out.println("i:" + i + "j:" + j);
                    pairs.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
                }
                
                if (r < words[i].length()) ++r;
                else ++l;
            }
        }
        return pairs;
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; ++ i)
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }
}


//150ms O(k * n ^ 2)

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words){
        
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            // System.out.println(words[i]);
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        }
        return ret;
    }
    
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
}





