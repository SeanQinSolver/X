public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        List<String> result = new ArrayList<String>();
        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            boolean hasAnagram = false;
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j]) && !visited[j]) {
                    result.add(strs[j]);
                    visited[j] = true;
                    hasAnagram = true;
                }
            }
            if (!visited[i] && hasAnagram) {
                result.add(strs[i]);
            }
        }
        return result;
    }
    
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}

//Method2 Hashmap

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedS = String.valueOf(c);
            if (!map.containsKey(sortedS)) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sortedS, list);
            } else {
                ArrayList<String> list = map.get(sortedS);
                list.add(s);
                map.put(sortedS, list);
            }
        }
        
        List<String> result = new ArrayList<String>();
        for(List<String> temp : map.values()) {
            if (temp.size() > 1) {
                result.addAll(temp);
            } 
        }
        return result;
    }
}