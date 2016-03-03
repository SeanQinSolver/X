public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (num == null) return result;
        
        Arrays.sort(num);
        helper(num, 0, target, list, result);
        return result;
    }
    private void helper(int[] num, int start, int gap, 
    List<Integer> list, List<List<Integer>> result) {
        if (gap == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < num.length; i++) {
            if (i != start && num[i] == num[i - 1]) {
                continue;
            }
            
            if (gap < num[i]) {
                return;
            }
            
            list.add(num[i]);
            
            helper(num, i + 1, gap - num[i], list, result);
            list.remove(list.size() - 1);
        }
        
    }    
}