class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        Collections.sort(nums);
        int[] visited = new int[nums.size()];
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(nums, result, path, visited);
        return result;
    }
    public void dfs(ArrayList<Integer> num, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] visited) {
        if(list.size() == num.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < num.size(); i++) {
            //visited[i]是判断在此recursion下访问过没有
            //num.get(i) == num.get(i - 1)判定重复
            if (visited[i] == 1 || (i != 0 && num.get(i) == num.get(i - 1) && visited[i - 1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(num.get(i));
            dfs(num, result, list, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}


