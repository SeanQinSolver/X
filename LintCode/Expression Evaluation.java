public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<String> opStack = new Stack<String>();
        
        for (int i = 0; i < expression.length; i++) {
            String curStr = expression[i];
            if (isOperator(curStr)) {
                if (curStr.equals("(")) {
                    //左括号
                    opStack.push(curStr);
                } else if (curStr.equals(")")) {
                    //右括号
                    while (!opStack.peek().equals("(")) {
                        int temp = cal(intStack.pop(), intStack.pop(), opStack.pop());
                        intStack.push(temp);
                    }
                    //去掉 ")"
                    opStack.pop();
                } else {
                    //加减乘除号
                    //或者while (!opStack.isEmpty() && precedence(curStr, opStack.peek()))
                    while (!opStack.isEmpty() && getOrder(curStr) <= getOrder(opStack.peek())) {
                        int temp = cal(intStack.pop(), intStack.pop(), opStack.pop());
                        intStack.push(temp);
                    }
                    opStack.push(curStr);
                }
            } else {
                //只是数字，直接进站
                intStack.push(Integer.valueOf(curStr));
            }
        }
        
        while (!opStack.isEmpty()) {
            int temp = cal(intStack.pop(), intStack.pop(), opStack.pop());
            intStack.push(temp);
        }
        return intStack.isEmpty() ? 0 : intStack.pop();
    }
    private boolean isOperator (String str) {
        if (str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-") || str.equals(")") || str.equals("(")) {
            return true;
        } else {
            return false;
        }
    }
    
    private int cal(int a, int b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return b - a;
        } else if (op.equals("*")) {
            return a * b;
        } else {
            return b / a;
        }
    }
    //可用getorder或者precedence获取特权关系
    private boolean precedence(String a, String b) {
        if (b.equals("*") || b.equals("/")) {
            return true;
        }
        if (b.equals("+") || b.equals("-")) {
            if (a.equals("*") || a.equals("/")) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
    
    private int getOrder(String str) {
        if (str.equals("*") || str.equals("/")) return 2;
        else if (str.equals("+") || str.equals("-")) return 1;
        else return 0;
    }
};