public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    class NumbersComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0') {
                index++;
            }
        }
        if (index == result.length()) {
            return "0";
        }
        return result;
    }
}