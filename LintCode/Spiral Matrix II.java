public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        } 
        int[][] result = new int[n][n];
        
        int xStart = 0;
        int yStart = 0;
        int num = 1;
        while (n > 0) {
            if (n == 1) {
                result[yStart][xStart] = num++;
                break;
            }
            
            for (int i = 0; i < n - 1; i++) {
                result[yStart][xStart + i] = num++;
            }
            
            for (int i = 0; i < n - 1; i++) {
                result[yStart + i][xStart + n - 1] = num++;
            }
            
            for (int i = 0; i < n - 1; i++) {
                result[yStart + n - 1][xStart + n - 1 - i] = num++;
            }
            
            for (int i = 0; i < n - 1; i++) {
                result[yStart + n - 1 - i][xStart] = num++;
            }
            
            xStart++;
            yStart++;
            n -= 2;
        }
        return result;
    }
}

//此题注意在循环进入的第一时要判断是否n == 1此时为最后一个，则直接赋值退出