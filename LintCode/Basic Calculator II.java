public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        //这里用linkedlist而不用stack是方便后面的+,-运算
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                int cur = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if (!stack.isEmpty() && (stack.peek() == 2 || stack.peek() == 3)) {
                    int operater = stack.pop();
                    int curNext = stack.pop();
                    int res = 0;
                    if (operater == 2) res = curNext * cur;
                    else res = curNext / cur;
                    stack.push(res);
                } else {
                    stack.push(cur);
                }
            } else {
                switch (c) {
                    case '+':
                        stack.push(0);
                        break;
                    case '-':
                        stack.push(1);
                        break;
                    case '*':
                        stack.push(2);
                        break;
                    case '/':
                        stack.push(3);
                        break;
                    default:
                        return -1;
                }
            }
        }
        Collections.reverse(stack);
        
        
        int result = stack.pop();
        while (!stack.isEmpty()) {
            int operator = stack.pop();
            int num1 = stack.pop();
            if (operator == 0) result += num1;
            else if (operator == 1) result -= num1;
        }
        
        return result;
    }
}