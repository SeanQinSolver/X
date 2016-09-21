//method1
public class TicTacToe {
    
    int[][] board;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        board[row][col] = player;
        int i = 0, j = 0, N = board.length;
        
        for (i = 0; i < N; i++) {
            if (board[i][0] != 0) {
                for (j = 1; j < N; j++) {
                    if (board[i][j] != board[i][j - 1]) break;
                }
                if (j == N) return board[i][0];
            }
        }
        
        for (i = 0; i < N; i++) {
            if (board[0][i] != 0) {
                for (j = 1; j < N; j++) {
                    if (board[j][i] != board[j - 1][i]) break;
                }
                if (j == N) return board[0][i];
            }
        }
        
        if (board[0][0] != 0) {
            for (i = 1; i < N; i++) {
                if (board[i][i] != board[i - 1][i - 1]) break;
            }
            if (i == N) return board[0][0];
        }
        
        if (board[N - 1][0] != 0) {
            for (i = 1; i < N; i++) {
                if (board[N - 1 - i][i] != board[N - i][i - 1]) break;
            }
            if (i == N) return board[N - 1][0];
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
//method2



public class TicTacToe {
    
    int[] rows;
    int[] cols;
    int diag = 0;
    int rev_diag = 0;
    int N = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        N = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rows[row] += add;
        cols[col] += add;
        diag += (row == col ? add : 0);
        rev_diag += (row == N - col - 1 ? add : 0);
        return Math.abs(rows[row]) == N || Math.abs(cols[col]) == N || Math.abs(diag) == N || Math.abs(rev_diag) == N ? player : 0;
    }
}