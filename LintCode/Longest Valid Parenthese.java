public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(i - start + 1, maxLen);
                    } else {
                        maxLen = Math.max(i - stack.peek(), maxLen);
                    }
                }
            }
        }
        return maxLen;
    }
}

//1。若是‘(’直接push到Stack>
//2。若不是‘(’则先判断是否stack为空。若空，则说明加上当前右括号没有合法序列(有也是之前判断过的)
//3。若不空，则弹出后一个栈顶元素。若弹出后为空，则当前长度为之前维护的合法start计算：i - start + 1。若栈内仍有元素，则长度为当前栈顶元素peek()到当前元素的距离
//时间复杂度：O(N)， 空间复杂度：O(N) -》最坏情况都是左括号