public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (int k = 1; k <= 9; k++) {
                    board[i][j] = (char)(k + '0');
                    if (isValid(board, i, j) && solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int a, int b) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < 9; i++) {
            if (set.contains(board[a][i])) return false;
            if (board[a][i] > '0' && board[a][i] <= '9') set.add(board[a][i]);
        }
        
        set = new HashSet<Character>();
        for (int i = 0; i < 9; i++) {
            if (set.contains(board[i][b])) return false;
            if (board[i][b] > '0' && board[i][b] <= '9') set.add(board[i][b]);
        }
        
        set = new HashSet<Character>();
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                
                if (set.contains(board[x][y])) return false;
                if (board[x][y] > '0' && board[x][y] <= '9') set.add(board[x][y]);
                
            }
        }
        return true;
    }
}

//method2 优化is valid

private boolean isValid(char[][] board, int a, int b) {
        for (int j = 0; j < 9; j++) {
        if (j != b && board[a][j] == board[a][b]) return false;
    }

        for (int j = 0; j < 9; j++) {
        if (j != a && board[j][b] == board[a][b]) return false;
    }

        for (int i = a / 3 * 3; i < a / 3 * 3 + 3; i++) {
        for (int j = b / 3 * 3; j < b / 3 * 3 + 3; j++) {
        if ((i != a || j != b) && board[a][b] == board[i][j])
            return false;
    }
}
    return true;
}

//优化三
private boolean isValid(char[][] board, int a, int b) {
for (int j = 0; j < 9; j++) {
if (j != b && board[a][j] == board[a][b]) return false;
if (j != a && board[j][b] == board[a][b]) return false;
}
for (int i = a / 3 * 3; i < a / 3 * 3 + 3; i++) {
for (int j = b / 3 * 3; j < b / 3 * 3 + 3; j++) {
if ((i != a || j != b) && board[a][b] == board[i][j]) return false;
}
}
return true;
}
