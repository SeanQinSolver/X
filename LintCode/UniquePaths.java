public class UniquePaths {

	private int result = 0;

	public int uniquePaths(int m, int n) {
    	
    	int[][] sum = new int[m][n];
    	for (int i = 0; i < m; i++) {
    		sum[i][0] = 1;
    	}
    	for (int i = 0; i < n; i++) {
    		sum[0][i] = 1;
    	}
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			sum[i][j] = sum[i - 1][j] + sum[i][j - 1]; 
    		}
    	}
    	return sum[m - 1][n - 1];
    }

    public static void main(String[] args) {
    	int m = 3;
    	int n = 2;
    	UniquePaths ups = new UniquePaths();
    	int res = ups.uniquePaths(3, 2);
    	System.out.println(res);
    }
}

// x x x x
// x x x x
// x x x x