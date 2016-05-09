public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        if (numRows == 0) return rst;
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        rst.add(prev);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> path = new ArrayList<Integer>(i + 1);
            for (int j = 0; j <= i; j++) {
                //ArrayList需要先添加以后在用set(index,value)去修改
                path.add(-1);
            }
            //List<Integer> prev = rst.get(i - 1);
            path.set(0, prev.get(0));
            path.set(i, prev.get(i - 1));
            for (int k = 1; k < i; k++) {
                path.set(k, prev.get(k - 1) + prev.get(k));
            }
            rst.add(path);
            prev = path;
        }
        return rst;
    }
}