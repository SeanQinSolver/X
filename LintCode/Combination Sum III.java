public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        int gap = n;
        dfs(rst, path, gap, k, 1);
        return rst;
    }
    
    private void dfs(List<List<Integer>> rst, List<Integer> path, int gap, int k, int pos) {
        if (path.size() == k) {
            if (gap == 0) {
                rst.add(new ArrayList<Integer>(path));
            }
        }
        //注意这里只能每个数到9
        for (int i = pos; i <= 9; i++) {
            if (i > gap) {
                return;
            }
            path.add(i);
            dfs(rst, path, gap - i, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}