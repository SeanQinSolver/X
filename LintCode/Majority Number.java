public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) return 0;
        
        int count = 0;
        int key = -1;
        for (Integer num : nums) {
            if (count == 0) {
                key = num;
                count = 1;
                continue;
            }
            if (key == num) {
                count++;
            } else {
                count--;
            }
            
        }
        return key;
    }
}

//使用一个key来pk其他的数


//method2 hashmap more space

public class Solution {

    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.length == 0) {
            reutrn 0;
        }
        Hashmap<Integer, Integer> map = new Hashmap<Integer, Integer>()
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) * 2 > nums.length) {
                    return map.get(num);
                }
                continue;
            }
            map.put(num, 1);
        }
        return 0;
    }
}