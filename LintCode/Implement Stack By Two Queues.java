class Stack {
    // Push a new item into the stack
    Queue<Integer> q1;
    Queue<Integer> q2;
    
    public Stack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    
    public void push(int x) {
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        q1.offer(x);
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }
    
    // Pop the top of the stack
    public void pop() {
        if (!q1.isEmpty()) {
            q1.poll();
        }
    }
    
    // Return the top of the stack
    public int top() {
        // Write your code here
        if (!q1.isEmpty()) {
            return q1.peek();
        }
        return -1;
    }
    
    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty();
    }
}
//using the method of Queue's poll() and peek() and offer().
//notice: Stack's method are poll(), peek() and push()