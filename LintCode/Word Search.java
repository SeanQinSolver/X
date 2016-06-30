public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    result = true;
                }
            }
        }
        return result;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;
        
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            if (k == word.length() - 1) {
                return true;
            } else if (dfs(board, word, i - 1, j, k + 1)
                       || dfs(board, word, i + 1, j, k + 1)
                       || dfs(board, word, i, j - 1, k + 1)
                       || dfs(board, word, i, j + 1, k + 1)) {
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}


//METHOD2

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        
        int m = board.length;
        int n = board[0].length;
        
        boolean result = false;
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(i, j, board, word, 0)) {
                    result = true;
                }
            }
        }
        return result;
    }
    
    private boolean search(int i, int j, char[][] board, String word, int count) {
        if (i > board.length - 1 || j > board[0].length - 1|| i < 0 || j < 0) return false;
        
        if (board[i][j] != word.charAt(count)) return false;
        
        char temp = board[i][j];
        board[i][j] = '#';
        
        if (word.length() - 1 == count) {
            return true;
        } else if (search(i + 1, j, board, word, count + 1) || search(i, j + 1, board, word, count + 1) || search(i - 1, j, board, word, count + 1) || search(i, j - 1, board, word, count + 1)){
            return true;
        }
        board[i][j] = temp;
        
        return false;
    }
}