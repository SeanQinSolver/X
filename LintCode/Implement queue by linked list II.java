public class Dequeue {
    
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
    public Dequeue() {
        head = new LinkedListNode<Integer>(Integer.MIN_VALUE);
        tail = head;
        
    }

    public void push_front(int item) {
        if (head.value == Integer.MIN_VALUE) {
			head.value = item;
		} else {
			LinkedListNode<Integer> front = new LinkedListNode<Integer>(item);
			front.next = head;
			head.prev = front;
			head = front;
		}
        
    }

    public void push_back(int item) {
        if (tail.value == Integer.MIN_VALUE) {
			tail.value = item;			
		} else {
			LinkedListNode<Integer> next = new LinkedListNode<Integer>(item);
			tail.next = next;
			next.prev = tail;
			tail = next;
		}
    }

    public int pop_front() {
        LinkedListNode<Integer> result;
		result = head;
		//if there is no node any more
		if (head.next == null) {
			int i = result.value;
			head.value = Integer.MIN_VALUE;
			return i;
		}
		head.next.prev = null;
		head = head.next;
		return result.value;
    }

    public int pop_back() {
        LinkedListNode<Integer> result;
		result = tail;
		//if there is no node any more
		if (head == tail && tail.next == null) {
			int i = result.value;
			head.value = Integer.MIN_VALUE;
			return i;
		}
		tail.prev.next = null;
		tail = tail.prev;
		return result.value;
        
    }
}

class LinkedListNode<Integer> {
    protected int value;
    protected LinkedListNode next;
    protected LinkedListNode prev;
    public LinkedListNode(int v) {
        value = v;
    }
}

//Method2

public class Dequeue {
    LinkedList<Integer> list;
    
    public Dequeue() {
        list = new LinkedList<Integer>();
    }
    
    public void push_front(int item) {
        list.addFirst(item);
    }
    
    public void push_back(int item) {
        list.addLast(item);
    }
    
    public int pop_front() {
        if (!list.isEmpty()) {
            return list.removeFirst();
        }
        return -1;
    }
    
    public int pop_back() {
        if (!list.isEmpty()) {
            return list.removeLast();
        }
        return -1;
    }
}