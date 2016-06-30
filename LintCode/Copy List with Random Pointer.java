//method1 最牛算法，直接复制

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null ) return null;
        if (head.next == null) return new RandomListNode(head.label);
        
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode move1 = dummy;
        RandomListNode move2 = dummy;
        RandomListNode move = head;
        while (move != null) {
            move1.next = new RandomListNode(move.label);
            move1 = move1.next;
            move = move.next;
        }
        move = head;
        while (move != null) {
            if (move.random != null) {
                move2.next.random = move.random;
                //System.out.println("11");
            }
            move2 = move2.next;
            move = move.next;
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curr = dummy;
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            curr.next = newNode;
            map.put(head, newNode);
            //将新节点的RANDOM指向以前的RANDOM所指向的节点。新旧交叉
            newNode.random = head.random;
            head = head.next;
            curr = curr.next;
        }
        curr = dummy.next;
        while (curr != null) {
            if (curr.random != null) {
                //获取
                RandomListNode node = map.get(curr.random);
                curr.random = node;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

//method1 写法2, 在copy的时候不copy原来的random指针。在重新遍历的时候再copy

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode move = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        
        RandomListNode point = head;
        
        while (point != null) {
            RandomListNode newNode = new RandomListNode(point.label);
            move.next = newNode;
            map.put(point, newNode);
            point = point.next;
            move = newNode;
        }
        
        point = head;
        
        while (point != null) {
            if (point.random != null) {
                RandomListNode temp = map.get(point);
                temp.random = map.get(point.random);
            }
            point = point.next;
        }
        return dummy.next;
    }
}


//method2, 用hashmap判断一次


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curr = dummy;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        while (head != null) {
            RandomListNode newNode = null;
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            curr.next = newNode;
            
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            
            head = head.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}


//method3 不用hashmap 原地复制3次遍历

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode point = dummy;
        
        RandomListNode move = head;
        //复制node 1->1‘->2->2’->3->3'
        while (move != null) {
            RandomListNode newNode = new RandomListNode(move.label);
            newNode.next = move.next;
            move.next = newNode;
            move = move.next.next;
        }
        
        move = head;
        while (move != null) {
            if (move.random != null) {
                RandomListNode random1 = move.random;
                move.next.random = random1.next;
            }
            move = move.next.next;
        }
        
        //注意此点的交叉fuyuan.细读下面的代码
        RandomListNode dummy1 = head.next;
        move = head;
        
        while (move != null) {
            RandomListNode newNode = move.next;
            move.next = move.next.next;
            move = move.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }
        }
        return dummy1;
    }
}
