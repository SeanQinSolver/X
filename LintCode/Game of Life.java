public class Solution {
    
    private static final int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    
    // Dead->Dead: 0; Live->Live : 1; Live->Dead: 2; Dead->Live:3
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lives = getLiveNeighbors(board, i, j);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    //System.out.println(i + "  " + j + "%%%");
                    board[i][j] += 2;
                } else if (board[i][j] == 0 && lives == 3) {
                    board[i][j] += 2;
                    System.out.println(i + "  " + j);
                    //2右移一位相当除2－》 2/2 ＝ 1， 这里不能加3加上3相当于这批generation又算上这一个live了
                    //System.out.println(board[i][j]);
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int getLiveNeighbors(int[][] board, int i, int j) {
        int lives = 0;
        for (int[] dir : direction) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 1 || board[x][y] == 3) {
                lives++;
            }
        }
        return lives;
    }
    
    
}