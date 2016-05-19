public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return 0;
        
        int count1 = 0, key1 = -1;
        int count2 = 0, key2 = -1;
        for (Integer num : nums) {
            if (count1 == 0) {
                count1 = 1;
                key1 = num;
                continue;
            } else if (count2 == 0 && key1 != num) {
                count2 = 1;
                key2 = num;
                continue;
            }
            
            if (num == key1) {
                count1++;
            } else if (num == key2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (Integer num : nums) {
            if (num == key1) {
                count1++;
            } else if (num == key2) {
                count2++;
            }
        }
        return count1 > count2 ? key1 : key2;
    }
}

//使用两个key来存储最多的两个数


//LEETCODE 求所有出现次数大于1/3的数

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        
        int k = nums.length / 3;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > k) rst.add(entry.getKey());
        }
        return rst;
    }
}
