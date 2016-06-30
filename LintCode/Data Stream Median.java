public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int len = nums.length;
        maxHeap = new PriorityQueue<Integer>(len / 2, Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>(len / 2);
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            addNums(nums[i]);
            result[i] = getMedian();
        }
        return result;
    }
    
    private void addNums(int addIn) {
        if (maxHeap.size() == minHeap.size()) {
            if (!minHeap.isEmpty() && addIn > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(addIn);
            } else {
                maxHeap.offer(addIn);
            }
        } else {
            if (maxHeap.peek() > addIn) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(addIn);
            } else {
                minHeap.offer(addIn);
            }
        }
    }
    
    private int getMedian() {
        if (maxHeap.size() == 0) return 0;
        return maxHeap.peek();
    }
}