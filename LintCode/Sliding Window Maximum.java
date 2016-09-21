//method1 O(N)

//维护一个k的窗口，for (int i = 0; i < nums.length; i++)每一个i把最左边的数给去掉
//arraydeque里面存index， 用queue.peekFirt() == i - k来判断是否是第一个。

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return rst;
        
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peekFirst() == i - k) queue.pollFirst();
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if ((i + 1) >= k) rst.add(nums[queue.peekFirst()]);
        }
        return rst;
    }
}

//METHOD2 RUMTIME o(nlogn) TLE on lintcode

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) return list;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) pq.remove(nums[i - k]);
            pq.offer(nums[i]);
            if (i + 1 >= k) list.add(pq.peek());
        }
        return list;
    }
}


//leetcode

//method1 priority queue nlog pass
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] rst = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) queue.remove(nums[i - k]);
            queue.offer(nums[i]);
            if (i + 1 >= k)
                rst[index++] = queue.peek();
        }
    }
}

//deque


public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] rst = new int[nums.length - k + 1];
        if (nums == null || nums.length == 0) return new int[0];
        
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i + 1 >= k) {
                rst[index++] = nums[queue.peekFirst()];
            }
        }
        
        return rst;
    }
}
