public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int length = matrix.length;
        
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < (length + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j -1 ][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;
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
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        
        int m = matrix.length;
        
        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < m - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - j - 1][i];
                matrix[m - j - 1][i] = matrix[m - i - 1][m - j - 1];
                matrix[m - i - 1][m - j - 1] = matrix[j][m - i - 1];
                matrix[j][m - i - 1] = temp;
            }
        }
    }
}


//此题注意i, j起始位置是[0, 0], [0, 1], [1, 0]