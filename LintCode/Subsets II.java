public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.size() ==0) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        Collections.sort(num);
        helper(result, path, num, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> path, ArrayList<Integer> num, int pos) {
        
        result.add(new ArrayList<Integer>(path));
        
        for (int i = pos; i < num.size(); i++) {
            if (i != pos && num.get(i) == num.get(i - 1)) {
                continue;
            }
            path.add(num.get(i));
            helper(result, path, num, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
