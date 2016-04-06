class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        if (dictionary == null) {
            return new ArrayList<String>();
        }
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        for (int i = 0; i < dictionary.length; i++) {
            if (!map.containsKey(dictionary[i].length())) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(dictionary[i]);
                map.put(dictionary[i].length(), list);
            } else {
                map.get(dictionary[i].length()).add(dictionary[i]);
            }
            maxLength = Math.max(maxLength, dictionary[i].length());
        }
        return map.get(maxLength);
    }
};

//写法二

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        if (dictionary == null ||  dictionary.length == 0) return new ArrayList<String>();
        
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        int max = Integer.MIN_VALUE;
        for (String s : dictionary) {
            int key = s.length();
            if (map.containsKey(key)) {
                map.get(key).add(s);
                continue;
            }
            map.put(key, new ArrayList<String>());
            map.get(key).add(s);
            max = Math.max(key, max);
        }
        return map.get(max);
    }
};