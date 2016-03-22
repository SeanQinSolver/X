public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        //path是存储k个元素搭配的。0是起点
        helper(result, path, A, k, target, 0);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path
                        , int[] A, int k, int remain, int index) {
        if (k == path.size() && remain == 0) {
            result.add(path);
            return;
        }
        for (int i = index; i < A.length; i++) {
            path.add(A[i]);
            helper(result, path, A, k, remain - A[i], index);
            path.remove(path.size() - 1);
        }
    }
}