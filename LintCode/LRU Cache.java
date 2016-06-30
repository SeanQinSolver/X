public class Solution {
    
    
    
    private static class Node {
        int key;
        int val;
        Node left, right;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.left = this.right = null;
        }
    }
    
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private int capacity;
    // @param capacity, an integer
    
    public Solution(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.right = tail;
        tail.left = head;
        this.capacity = capacity;
    }
    
    // @return an integer
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        //remove current
        Node node = map.get(key);
        node.left.right = node.right;
        node.right.left = node.left;
        //move to tail
        move_to_tail(node);
        
        return node.val;
    }
    
    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (get(key) != -1) {
            Node node = map.get(key);
            node.val = value;
            return;
        }
        
        if (map.size() == capacity) {
            map.remove(head.right.key);
            head.right = head.right.right;
            head.right.left = head;
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        move_to_tail(node);
        
    }
    
    private void move_to_tail(Node node) {
        node.left = tail.left;
        tail.left = node;
        node.left.right = node;
        node.right = tail;
    }
}