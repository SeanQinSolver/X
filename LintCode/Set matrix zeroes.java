public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
     
    //将第一行与第一列作为零。
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean empty_row = false;
        boolean empty_col = false;
        //若第一行作为标准，有零则退出
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                empty_row = true;
                break;
            }
        }
        //若第一列作为标准，有零则退出
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                empty_col = true;
                break;
            }
        }
        //从[1][1]开始若有零，则相应第一行或第一列为零
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //从[1][1]开始，若第一行/列为零，则相应的点变为零
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //第一行设为零
        if (empty_row) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
        //第一列设为零
        if (empty_col) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}


//写法2

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    
    //将第一行与第一列作为零。
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        boolean first_row_empty = false;
        boolean first_col_empty = false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) first_row_empty = true;
                    if (j == 0) first_col_empty = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (first_row_empty) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (first_col_empty) {
            for (int j = 0; j < m; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}