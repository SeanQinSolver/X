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