class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            //same col
            if (cols.get(i) == col) {
                return false;
            }
            if ((row - i) == Math.abs(col-cols.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    private int search(ArrayList<Integer> cols, int n, int row) {
        if (row == n) {
            return 1;
        }
        
        int num = 0;
        
        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            num += search(cols, n, row + 1);
            cols.remove(cols.size() - 1);
        }
        return num;
    }
    
    
    public int totalNQueens(int n) {
        
        ArrayList<Integer> cols = new ArrayList<Integer>();
        //search(cols, n, 0);
        return search(cols, n, 0);
    }
};


//写法2 不用row
class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        
        for (int i = 0; i < row; i++) {
            if (cols.get(i) == col) return false;
            //row对应的就是col，那么x坐标之差等于y坐标之差
            if (Math.abs(row - i) == Math.abs(col-cols.get(i))) {
                return false;
            }
        }
        return true;
    }
    private int search(ArrayList<Integer> cols, int n) {
        
        if (cols.size() == n) {
            return 1;
        }
        
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) continue;
            cols.add(col);
            count += search(cols, n);
            cols.remove(cols.size() - 1);
        }
        return count;
    }
    public int totalNQueens(int n) {
        ArrayList<Integer> cols = new ArrayList<Integer>();
        int result = search(cols, n);
        return result;
    }
};