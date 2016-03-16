public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (candidates == null) return result;
        
        Arrays.sort(candidates);
        helper(candidates, 0, target, list, result);
        return result;
    }
    
    private void helper(int[] candidates, int pos, int gap, List<Integer> list, List<List<Integer>> result) {
        if (gap == 0)
        {
            result.add(new ArrayList<Integer>(list));
            return;∂
        }
        
        if (gap < 0) {
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            if (gap < candidates[i]) {
                return;
            }
            
            list.add(candidates[i]);
            helper(candidates, i, gap - candidates[i], list, result);
            list.remove(list.size() - 1);
            
        }
    }
}



// list.add(2);
// helper(0, 5);

// list.add(2);
// helper(0, 3);

// list.add(2);    ->     list.add(3);
// helper(0, 1);           helper(1, 0);  gap = 0, so list added (2, 2, 3)

// gap < candidates[0] return