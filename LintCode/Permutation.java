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
        dfs(nums, path, result);
        return result;
    }
    private void dfs(ArrayList<Integer> nums, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (path.size() == nums.size()) {
            result.add(new ArrayList<Integer>(path));
        }
        for (int m = 0; m < nums.size(); m++) {
            if (path.contains(nums.get(m))) continue;
            path.add(nums.get(m));
            dfs(nums, path, result);
            path.remove(path.size() - 1);
        }
    }
    
}


//dfs searching