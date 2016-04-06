public class Queue {
    
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> point;
    public Queue() {
        head = new LinkedListNode<Integer>(Integer.MIN_VALUE);
        point = head;
    }

    public void enqueue(int item) {
        if (head.value == Integer.MIN_VALUE) {
            head.value = item;
        } else {
            LinkedListNode<Integer> next = new LinkedListNode<Integer>(item);
            point.next = next;
            point = next;
        }
    }

    public int dequeue() {
        LinkedListNode<Integer> result;
        result = head;
        if (head.next == null) {
            int i = result.value;
            head.value = Integer.MIN_VALUE;
            return i;
        }
        head = head.next;
        return result.value;
    }
    
    class LinkedListNode<Integer> {
        protected int value;
        protected LinkedListNode next;
        public LinkedListNode(int v) {
            value = v;
        }
    }
}

//method2

public class Queue {
    
    LinkedList<Integer> list;
    public Queue() {
        list = new LinkedList<Integer>();
    }
    
    public void enqueue(int item) {
        list.addLast(item);
    }
    
    public int dequeue() {
        if (!list.isEmpty()) {
            return list.removeFirst();
        }
        return -1;
    }
}