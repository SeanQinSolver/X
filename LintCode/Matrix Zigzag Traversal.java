public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int index = 0;
        int[] result = new int[(m + 1) * (n + 1)];
        for (int i = 0; i <= m + n; i++) {
            if (i % 2 == 0) {
                for (int x = i; x >= 0; x--) {
                    if ((x <= m) && (i - x <= n)) {
                        result[index] = matrix[x][i - x];
                        index++;
                    }
                }
            } else {
                for (int x = 0; x <= i; x++) {
                    if ((x <= m) && (i - x <= n)) {
                        result[index] = matrix[x][i - x];
                        index++;
                    }
                }
            }
        }
        return result;
    }
}