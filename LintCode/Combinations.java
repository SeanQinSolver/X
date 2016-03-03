public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        
        assert(n >= 1 && n >= k && k >=1);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		helper(n, k, 1, result, list);
		return result;
    }
    private void helper(int n, int k, int pos, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i <= n; i++) {
            list.add(i);
            helper(n, k, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}