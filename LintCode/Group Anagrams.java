public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String s1 = String.valueOf(temp);
            if (map.containsKey(s1)) {
                List<String> list = map.get(s1);
                list.add(s);
                map.put(s1, list);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(s1, list);
            }
        }
        
        
        
        for (String s : map.keySet()) {
            List<String> temp = map.get(s);
            Collections.sort(temp);
            rst.add(temp);
        }
        return rst;
    }
}

//treemap
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        //HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
        
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String newStr = String.valueOf(array);
            ArrayList<String> set = map.getOrDefault(newStr, new ArrayList<String>());
            set.add(str);
            map.put(newStr, set);
        }
        
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}