class Stack {
    LinkedList<Integer> list = new LinkedList<Integer>();
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        list.addLast(x);
    }
    
    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if (list.size() == 0) {
            return;
        }
        list.removeLast();
    }
    
    // Return the top of the stack
    public int top() {
        // Write your code here
        if (list.size() != 0) {
            return list.peekLast();
        }
        return -1;
    }
    
    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return list.size() == 0;
    }    
}

//写法2

class Stack {
    
    LinkedList<Integer> list = new LinkedList<Integer>();
    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        list.addFirst(x);
    }
    
    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if (list.size() == 0) return;
        list.removeFirst();
    }
    
    // Return the top of the stack
    public int top() {
        // Write your code here
        if (list.size() != 0) return list.peek();
        return -1;
    }
    
    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return list.peek() == null;
    }    
}