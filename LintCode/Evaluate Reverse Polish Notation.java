public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        String operators = "*/+-";
        for (String s : tokens) {
            if (!operators.contains(s)) {
                stack.push(Integer.valueOf(s));
                continue;
            }
            
            int a = stack.pop();
            int b = stack.pop();
            switch (s) {
                case "+":
                    stack.push(b + a);
                    break;
                case "-":
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(b * a);
                    break;
                case "/":
                    stack.push(b / a);
                    break;
            }
        }
        return stack.pop();
    }
}