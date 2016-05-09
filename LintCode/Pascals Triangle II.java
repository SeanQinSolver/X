public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        if (rowIndex == 0) {
            return prev;
        }
        
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> rst = new ArrayList<Integer>(i + 1);
            for (int j = 0; j <= i; j++) {
                rst.add(-1);
            }
            rst.set(0, prev.get(0));
            rst.set(i, prev.get(i - 1));
            for (int k = 1; k < i; k++) {
                rst.set(k, prev.get(k) + prev.get(k - 1));
            }
            for (int x : rst) {
                System.out.print(x + "  ");
            }
            System.out.println();
            prev = rst;
        }
        return prev;
    }
}