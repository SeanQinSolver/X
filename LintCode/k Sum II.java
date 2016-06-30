


//method1

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
        helper(0, A.length - 1, k, target, result, path, A);
        return result;
    }
    private void helper(int start, int end, int k, int gap, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int[] A) {
        if (path.size() == k && gap == 0) {
            result.add(new ArrayList<Integer>(path));
        }
        
        if (path.size() > k) return;
        
        for (int i = start; i <= end; i++) {
            if (A[i] > gap) {
                continue;
            }
            path.add(A[i]);
            
            //注意index这里从i + 1开始因为是unique number
            helper(i + 1, end, k, gap - A[i], result, path, A);
            path.remove(path.size() - 1);
        }
    }
}