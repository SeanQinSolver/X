public class MinStack {
    
    /** initialize your data structure here. */
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            stack2.push(Math.min(stack2.peek(), x));
        }
    }
    
    public void pop() {
        stack2.pop();
        stack1.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//写法2

public class MinStack {
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    //stack2只放置一个最小值
    public void push(int number) {
        stack1.push(number);
        int count = 0;
        if (!stack2.isEmpty() && stack2.peek() < number) {
            stack2.push(stack2.peek());
        } else {
            stack2.push(number);
        }
    }
    
    public int pop() {
        stack2.pop();
        return stack1.pop();
    }
    //stack2为只放置一个最小值
    public int min() {
        return stack2.peek();
    }
}
