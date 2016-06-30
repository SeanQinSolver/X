//follow up: Convert Expression to Polish Notation
public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        ArrayList<String> rst = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        //用stack去存储operator,遇到"("则push到stack里，
        for (int i = 0; i < expression.length; i++) {
            String str = expression[i];
            if (isOperator(str)) {
                if (str.equals("(")) {
                    stack.push(str);
                } else if (str.equals(")")){
                    while (!stack.isEmpty()) {
                        String s = stack.pop();
                        if (s.equals("(")) break;
                        rst.add(s);
                    }
                } else {
                    while (!stack.isEmpty() && getOrder(str) <= getOrder(stack.peek())) {
                        //将order大的在stack里的拿出来加入rst中
                        rst.add(stack.pop());
                    }
                    //将这个operator加到stack里
                    stack.push(str);
                }
            } else {
                rst.add(str);
            }
        }
        
        while (!stack.isEmpty()) {
            rst.add(stack.pop());
        }
        return rst;
    }
    //判断是否是operator
    private boolean isOperator(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("(") || str.equals(")")) {
            return true;
        }
        return false;
    }
    //获取order
    private int getOrder(String str) {
        if (str.equals("*") || str.equals("/")) return 2;
        else if (str.equals("+") || str.equals("-")) return 1;
        else return 0;
    }
}