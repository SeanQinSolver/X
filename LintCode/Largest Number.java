//method1
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


//写法2

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int len = nums.length;
        
        String[] array = new String[len];
        
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        };
        
        Arrays.sort(array, comp);
        
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        String result = sb.toString();
        
        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') break;
            count++;
        }
        result = (count == result.length()) ? "0" : result;
        return result;
    }
}