//method1 divide and conquer
//与Unique Binary tree 做法相同典型分制
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length() == 0) return result;
        
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (!checkOperator(temp)) continue;
            
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            
            for (int m : left) {
                for (int n : right) {
                    switch (temp) {
                        case '+':
                            result.add(m + n);
                            break;
                        case '-':
                            result.add(m - n);
                            break;
                        case '*':
                            result.add(m * n);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if (result.size() == 0) result.add(Integer.parseInt(input));
        return result;
    }
    private boolean checkOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}

//用hashmap存值

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        helper(input, map);
        return map.get(input);
    }
    
    private List<Integer> helper(String input, HashMap<String, List<Integer>> map) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        if (input == null || input.length() == 0) return result;
        
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (!checkOperator(temp)) continue;
            
            String leftInput = input.substring(0, i);
            String rightInput = input.substring(i + 1);
            
            List<Integer> left = map.containsKey(leftInput) ? map.get(leftInput) : helper(leftInput, map);
            List<Integer> right = map.containsKey(rightInput) ? map.get(rightInput) : helper(rightInput, map);
            
            for (int m : left) {
                for (int n : right) {
                    switch (temp) {
                        case '+':
                            result.add(m + n);
                            break;
                        case '-':
                            result.add(m - n);
                            break;
                        case '*':
                            result.add(m * n);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if (result.size() == 0) result.add(Integer.parseInt(input));
        map.put(input, result);
        return result;
    }
    
    private boolean checkOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}