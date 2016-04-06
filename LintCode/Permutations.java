class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(result, path, nums);
        return result;
    }
    private void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, ArrayList<Integer> nums) {
        if (path.size() == nums.size()) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (path.contains(nums.get(i))) continue;
            path.add(nums.get(i));
            dfs(result, path, nums);
            path.remove(path.size() - 1);
        }
    }
}
