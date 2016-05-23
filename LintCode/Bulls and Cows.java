public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); i++) {
            char c= secret.charAt(i);
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        boolean[] visited = new boolean[guess.length()];
        int count1 = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                char c = secret.charAt(i);
                map.put(c, map.get(c) - 1);
                visited[i] = true;
                count1++;
            }
        }
        int count2 = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (!visited[i] && map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
                char c = guess.charAt(i);
                map.put(c, map.get(c) - 1);
                visited[i] = true;
                count2++;
            }
        }
        
        return count1 + "A" + count2 + "B";
    }
}

//思路两次循环找