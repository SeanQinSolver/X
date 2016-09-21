public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (S == null || L == null || S.length() == 0 || L.length == 0) return rst;
        
        int wordLen = L[0].length();
        
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        
        for (String word : L) {
            // dict.put(L[i], dict.getOrDefault(L[i], 0) + 1);
            if (dict.containsKey(word)) {
                dict.put(word, dict.get(word) + 1);
            } else {
                dict.put(word, 1);
            }
        }
        
        
        for (int i = 0; i < wordLen; i++) {
            int count = 0;
            int index = i;
            
            HashMap<String, Integer> curdict = new HashMap<String, Integer>();
            
            for (int j = i; j <= S.length() - wordLen; j += wordLen) {
                String curWord = S.substring(j, j + wordLen);
                
                if (!dict.containsKey(curWord)) {
                    curdict.clear();
                    count = 0;
                    //System.out.println("index is moving");
                    index = j + wordLen;
                } else {
                    //curDict.put(curr, curDict.getOrDefault(curr, 0) + 1);
                    if (!curdict.containsKey(curWord)) {
                        curdict.put(curWord, 1);
                    } else {
                        curdict.put(curWord, curdict.get(curWord) + 1);
                    }
                    //System.out.println(curWord);
                    if (curdict.get(curWord) <= dict.get(curWord)) {
                        count++;
                    } else {
                        while (curdict.get(curWord) > dict.get(curWord)) {
                            String temp = S.substring(index, index + wordLen);
                            //System.out.println(temp);
                            curdict.put(temp, curdict.get(temp) - 1);
                            if (curdict.get(temp) < dict.get(temp)) count--;
                            //窗口向前移动
                            //System.out.println("index is moved");
                            index = index + wordLen;
                        }
                    }
                    //System.out.println(count);
                    if  (count == L.length) {
                        //System.out.println(index + "&&");
                        rst.add(index);
                        String temp = S.substring(index, index + wordLen);
                        curdict.put(temp, curdict.get(temp) - 1);
                        //窗口向前移动
                        index = index + wordLen;
                        count--;
                    }
                }
                
                
            }//end for j
        }//end for i
        return rst;
    }
}