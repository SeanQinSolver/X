public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        if (stack == null) {
            return;
        }
        Stack<Integer> helper = new Stack<Integer>();
        while (!stack.empty()) {
            Integer current = stack.pop();
            while (!helper.empty() && current > helper.peek()) {
                stack.push(helper.pop());
            }
            helper.push(current);
        }
        
        while (!helper.empty()) {
            stack.add(helper.pop());
        }
    }
}