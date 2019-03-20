// Simpler one run way

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] visited1 = new boolean[9][9];
        boolean[][] visited2 = new boolean[9][9];
        boolean[][] visitedSubGrid = new boolean[9][9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur == '.') continue;
                int col = cur - '1';
                int row = i / 3 * 3 + j / 3;
                
                if (visitedSubGrid[row][col] || visited1[i][col] || visited2[j][col] || col < 0 || col > 8) {
                    return false;
                }
                visitedSubGrid[row][col] = true;
                visited1[i][col] = true;
                visited2[j][col] = true;
            }
        }

        return true;
    }
}



public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        
        // row
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[i][j]))
                    return false;
            }
        }
        
        //col
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[j][i]))
                    return false;
            }
        }
        
        // sub matrix
        for(int i = 0; i<9; i+= 3){
            for(int j = 0; j<9; j+= 3){
                Arrays.fill(visited, false);
                for(int k = 0; k<9; k++){
                    if(!process(visited, board[i + k % 3][j + k / 3]))
                        return false;
                }
            }
        }
        return true;
        
    }
    
    private boolean process(boolean[] visited, char digit){
        if(digit == '.'){
            return true;
        }
        
        int num = digit - '0';
        if ( num < 1 || num > 9 || visited[num-1]){
            return false;
        }
        
        visited[num-1] = true;
        return true;
    }
};



//写法2

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        if (n == 0) return false;
        
        
        boolean[] visited = new boolean[board.length];
        
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!checkValid(visited, board, i, j)) {
                    return false;
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!checkValid(visited, board, j, i)) {
                    return false;
                }
            }
        }
        
        for (int i = 0; i < 9; i+= 3) {
            for (int j = 0; j < 9; j+=3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!checkValid(visited, board, i + k % 3, j + k / 3)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
        
    }
    private boolean checkValid(boolean[] visited, char[][] board, int i, int j) {
        int temp = board[i][j] - '0';
        if (board[i][j] == '.')  return true;
        
        if (temp < 1 || temp > 9 || visited[temp - 1]) {
            return false;
        }
        visited[temp - 1] = true;
        return true;
    }
};