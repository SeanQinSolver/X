public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    class sortComp implements Comparator<String>{
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
    
    
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new sortComp());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        String tempRes = sb.toString();
        int index = 0;
        while (index < tempRes.length()) {
            if (tempRes.charAt(index) != '0') {
                break;
            }
            index++;
        }
        if (index == tempRes.length()) {
            return "0";
        }
        return tempRes;
    }
}