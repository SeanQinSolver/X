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

// LinkedHashMap

public class LRUCache {
    //数据结构使用HASHMAP与DOUBLE LINKED LIST
    // search/get fast & delete/move fast
    
    LinkedHashMap<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return cache.size() > capacity;
            }
        };
    }
    
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            moveToTail(key);
            return value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        cache.put(key, value);
        moveToTail(key);
    }
    public void moveToTail(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

//get the node, remove it from current position, add it to the tail
//set the node, add it to the tail.
//call the method addtotail
//notice: least used cache