//naive o(m2 * n2)

public class Solution {
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return 0;
        }
        int[][] sum = new int[row][col];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < col; i++) {
            sum[0][i] = sum[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
        
        // for (int i = 0; i < row; i++) {
        //     for (int j = 0; j < col; j++) {
        //         System.out.println(sum[i][j] + " " + i + " " + j);
        //     }
        // }
        System.out.println("=========================");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int h = 0; h + i < row; h++) {
                    for (int w = 0; w + j < col; w++) {
                        int area = sum[i + h][j + w] - (i == 0 ? 0 : sum[i - 1][j + w]) - (j == 0 ? 0 : sum[i + h][j - 1]);
                        if (i != 0 && j != 0) {
                            area += sum[i - 1][j - 1];
                        }
                        if (area <= k) {
                            max = Math.max(area, max);
                        }
                        //System.out.println("area: " + area + " i: " + i + " j: " + j + " w: " + w + " h: "+ h);
                    }
                }
            }
        }
        return max;
    }
}
//space o(row) runntime o(col * col * row) TreeSet: NLogN

//https://www.youtube.com/watch?v=yCQN096CwWM

public class Solution {
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return 0;
        }
        int[] cache = new int[row];
        
        int max = Integer.MIN_VALUE;
        
        for (int l = 0; l < col; l++) {
            Arrays.fill(cache, 0);
            for (int r = l; r < col; r++) {
                for (int m = 0; m < row; m++) {
                    cache[m] += matrix[m][r];
                }
                int area = calculate(cache, k);
                max = Math.max(area, max);
            }
            
        }
        return max;
    }
    private int calculate(int[] cache, int k) {
        
        int area = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(0);
        
        for (int i = 0; i < cache.length; i++) {
            int tmp = cache[i] + sum;
            sum = tmp;
            Integer gap = set.ceiling(sum - k);
            if (gap != null) {
                area = Math.max(area, sum - gap);
            }
            set.add(tmp);
        }
        return area;
    }
}

