public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) return 0;
        if (matrix[0] == null || matrix[0].length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int y = 0;
        int x = m - 1;
        
        int count = 0;
        while (x >= 0 && y < n) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}

//从左下或者右上开始搜索。可以达到m+n时间复杂度要求

//bottom left to top right
