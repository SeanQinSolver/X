public class Solution {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null && end == null) return 0;
        if (start.length() == 0 && end.length() == 0) return 0;
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        
        int ladderLen = 1;
        dict.add(end);
        Queue<String> q = new LinkedList<String>();
        Set<String> hash = new HashSet<String>();
        q.offer(start);
        hash.add(start);
        while (!q.isEmpty()) {
            ladderLen++;
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                String strTemp = q.poll();
                for (String nextWord : getNextWords(strTemp, dict)) {
                    if (nextWord.equals(end)) return ladderLen;
                    if (hash.contains(nextWord)) continue;
                    q.offer(nextWord);
                    hash.add(nextWord);
                }
            }
        }
        return 0;
    }
    private Set<String> getNextWords(String curr, Set<String> dict) {
        Set<String> nextWords = new HashSet<String>();
        for (int i = 0; i < curr.length(); i++) {
            char[] charSet = curr.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                charSet[i] = c;
                String temp = new String(charSet);
                if (dict.contains(temp)) {
                    nextWords.add(temp);
                }
            }
        }
        return nextWords;
    }
}

//method2 a new corner case start == end

public class Solution {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null && end == null) return 0;
        if (start.length() == 0 && end.length() == 0) return 0;
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        if (start.equals(end)) return 1;
        
        int ladderLen = 1;
        dict.add(end);
        
        Queue<String> q = new LinkedList<String>();
        Set<String> hash = new HashSet<String>();
        q.offer(start);
        hash.add(start);
        
        while (!q.isEmpty()) {
            ladderLen++;
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                String strTemp = q.poll();
                for (String nextWord : getNextWords(strTemp, dict)) {
                    //System.out.println(nextWord);
                    
                    if (hash.contains(nextWord)) continue;
                    
                    if (nextWord.equals(end)) return ladderLen;
                    
                    q.offer(nextWord);
                    hash.add(nextWord);
                }
            }
        }
        return 0;
    }
    
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    private Set<String> getNextWords(String word, Set<String> dict) {
        Set<String> nextWords = new HashSet<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}