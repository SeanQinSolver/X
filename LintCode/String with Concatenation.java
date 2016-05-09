//method1 TLE

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> toFind = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        int m = L.length, n = L[0].length();
        for (int i = 0; i < m; i ++){
            if (!toFind.containsKey(L[i])){
                toFind.put(L[i], 1);
            }
            else{
                toFind.put(L[i], toFind.get(L[i]) + 1);
            }
        }
        for (int i = 0; i <= S.length() - n * m; i ++){
            found.clear();
            int j;
            for (j = 0; j < m; j ++){
                int k = i + j * n;
                String stub = S.substring(k, k + n);
                if (!toFind.containsKey(stub)) break;
                if(!found.containsKey(stub)){
                    found.put(stub, 1);
                }
                else{
                    found.put(stub, found.get(stub) + 1);
                }
                if (found.get(stub) > toFind.get(stub)) break;
            }
            if (j == m) result.add(i);
        }
        return result;
    }
}

//method2

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (S == null || L == null || S.length() == 0 || L.length == 0) return rst;
        
        int wordLen = L[0].length();
        
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        
        for (String word : L) {
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
                    System.out.println("index is moving");
                    index = j + wordLen;
                } else {
                    if (!curdict.containsKey(curWord)) {
                        curdict.put(curWord, 1);
                    } else {
                        curdict.put(curWord, curdict.get(curWord) + 1);
                    }
                    System.out.println(curWord);
                    if (curdict.get(curWord) <= dict.get(curWord)) {
                        count++;
                    } else {
                        while (curdict.get(curWord) > dict.get(curWord)) {
                            String temp = S.substring(index, index + wordLen);
                            System.out.println(temp);
                            curdict.put(temp, curdict.get(temp) - 1);
                            if (curdict.get(temp) < dict.get(temp)) count--;
                            //窗口向前移动
                            System.out.println("index is moved");
                            index = index + wordLen;
                        }
                    }
                    System.out.println(count);
                    if  (count == L.length) {
                        System.out.println(index + "&&");
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
http://www.cnblogs.com/springfor/p/3872516.html
    
    http://blog.csdn.net/linhuanmars/article/details/20342851


    更好的解法就是一种滑动窗口式的。我是参照了http://blog.csdn.net/linhuanmars/article/details/20342851的写法，他的写法目前速度最快。
    
    首先是先把所给的字典利用HashMap建一下，key存word，value存这个word出现的个数。
    
    因为每个单词长度一样，外层循序只许循环wordLen次，每次指针挪一次，每一次循环遍历整个字符串。
    
    内层循环每次遍历一个单词，把整个S字符串遍历检查。
    
    需要在每次大循环维护一个count，看是不是达到了给的字典字符串数量，同时维护一个index，是每个符合条件的字符串的起始index，需要存到返回结果中。
    
    为了能够检查是不是合格字符串，在这里维护一个curDict的HashMap。
    
    
    
    首先检查一个单词是不是在原始字典中出现，没出现的话说明这个单词肯定不符合标准，index指针指向下一个单词的起始点，计数器和curDict都要清零。
    
    如果这个单词在原始字典里出现过，用更新原始字典的方法更新curDict，如果这个单词出现的次数没有超过原始字典里记录的次数，那么count++，如果超过了，就需要挪动指针，并把超过的从curDict删掉。
    
    最后，如果count达到了L的length，说明找到了一个合格的字符串，那么将index存入返回结果res中，再把index挪到下一个单词处，更新curDict即可。

