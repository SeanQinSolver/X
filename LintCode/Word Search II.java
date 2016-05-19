public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        
        TrieTree tree = new TrieTree();
        
        for (String s : words) {
            tree.insert(s);
        }
        System.out.println(tree.root.endWord);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(result, i, j, tree.root, board);
            }
        }
        return result;
    }
    
    
    private static final int[] dx = new int[]{1, 0, 0, -1};
    private static final int[] dy = new int[]{0, 1, -1, 0};
    
    private void search(List<String> result, int x, int y, TrieNode root, char[][] board) {
        if (root.endWord == true) {
            if (!result.contains(root.s)) result.add(root.s);
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '#'|| root == null) {
            return;
        }
        if (root.child.containsKey(board[x][y])) {
            for (int m = 0; m < 4; m++) {
                char temp = board[x][y];
                board[x][y] = '#';
                int newX = x + dx[m];
                int newY = y + dy[m];
                search(result, newX, newY, root.child.get(temp), board);
                board[x][y] = temp;
            }
        }
    }
    
    private static class TrieNode {
        boolean endWord;
        HashMap<Character, TrieNode> child;
        //s来记录TrieNode到末尾的时候所连接的word,也就是string value of this word
        String s;
        public TrieNode() {
            child = new HashMap<Character, TrieNode>();
            endWord = false;
            s = "";
        }
    }
    
    private static class TrieTree {
        TrieNode root;
        public TrieTree() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode now = root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (!now.child.containsKey(c)) {
                    now.child.put(c, new TrieNode());
                }
                now = now.child.get(c);
            }
            
            now.s = word;
            now.endWord = true;
        }
        
        public boolean search(String word) {
            TrieNode now = root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (!now.child.containsKey(c)) {
                    return false;
                }
                now = now.child.get(c);
            }
            return now.endWord == true;
        }
    }
}