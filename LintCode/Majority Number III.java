public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.isEmpty()) return -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.size();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                continue;
            }
            map.put(num, 1);
            if (map.size() >= k) {
                removeZeroCount(map);
            }
        }
        
        //reset
        for (int key : map.keySet()) {
            map.put(key, 0);
        }
        for (int key : nums) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }
        }
        
        //find max
        int maxKey = -1;
        int maxCount = 0;
        
        
        for (int key : map.keySet()) {
            if (map.get(key) > maxCount) {
                maxKey = key;
                maxCount = map.get(key);
            }
        }
        return maxKey;
    }
    
    private void removeZeroCount(HashMap<Integer, Integer> map) {
        Set<Integer> keySet = map.keySet();
        
        for (int key : keySet) {
            map.put(key, map.get(key) - 1);
        }
        
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getValue() == 0) { //可判断为1的，则上面45-49行则不要。
                it.remove();
            }
        }
    }
}

//思路是找出k-1个candidates,如果此candidates里面的各个candidate只出现了1次的话则删除此candidate
//可以先减去1，再删除为零的。继续把剩下的candidate求出来。
