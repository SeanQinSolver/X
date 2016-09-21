public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[left] + num[right] + num[i];
                if (sum == 0) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[left]);
                    tmp.add(num[right]);
                    result.add(tmp);
                    left++;
                    right--;
                    while (left < right && num[left] == num[left - 1]) {
                        left++;
                    }
                    while (left < right && num[right] == num[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

//method2: hashMap (2sum method)

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            map.clear();
            int curr = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                if (map.containsKey(curr - nums[left])) {
                    List<Integer> path = new ArrayList<Integer>();
                    path.add(nums[i]);
                    path.add(curr - nums[left]);
                    path.add(nums[left]);
                    Collections.sort(path);
                    result.add(path);
                } else {
                    map.put(nums[left], left);
                }
                left++;
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> li : result) {
            res.add(new ArrayList<Integer>(li));
        }
        
        return res;
    }
}