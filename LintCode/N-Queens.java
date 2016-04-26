class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    private ArrayList<String> drawCheckboard(ArrayList<Integer> cols) {
        ArrayList<String> chessboard = new ArrayList<String>(cols.size());
        StringBuilder sb;
        for (int i = 0; i < cols.size(); i++) {
            sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            //same column
            if (cols.get(i) == col) {
                return false;
            }
            //left-top and right-bottom
            if (i - row == cols.get(i) - col) {
                return false;
            }
            //right-top and left-bottm
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
    private void search(int n, ArrayList<Integer> cols, ArrayList<ArrayList<String>> result) {
        if (cols.size() == n) {
            for (int i : cols) {
                System.out.print(i + " ");
            }
            System.out.print("**");
            result.add(drawCheckboard(cols));
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            search(n, cols, result);
            cols.remove(cols.size() - 1);
        }
    }
    
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (n <= 0) {
            return result;
        }
        search(n, new ArrayList<Integer>(), result);
        return result;
    }
};