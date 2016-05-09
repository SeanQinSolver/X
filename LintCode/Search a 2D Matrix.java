//method1 2 binary search
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        //find the row, target >= the last number
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] < target) {
                start = mid;
            } else if (matrix[mid][0] > target) {
                end = mid;
            } else {
                return true;
            }
        }
        // 判断如果偶数行，最后有start与end.若是奇数行，则无此影响start=end
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        //find the column.
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] < target) {
                start = mid;
            } else if (matrix[row][mid] > target) {
                end = mid;
            } else {
                return true;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        } else {
            return false;
        }
    }
}

//metho2 1 binary search

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int start = -1;
        int end = row * col;
        
        
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / col][mid % col] < target) {
                start = mid;
            } else if (matrix[mid / col][mid % col] > target){
                end = mid;
            } else {
                return true;
            }
        }
        
        return false;
    }
}

return false;