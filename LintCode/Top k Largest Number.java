//method1
class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        Arrays.sort(nums);
        int[] rst = new int[k];
        int count = 0;
        while (count < k) {
            rst[count] = nums[nums.length - 1 - count];
            count++;
        }
        return rst;
    }
};

//method2 priorityqueue

class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };
        
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, comp);
        
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k) heap.offer(nums[i]);
            else if (comp.compare(nums[i], heap.peek()) > 0) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        
        
        int[] rst = new int[k];
        int count = 0;
        while (!heap.isEmpty()) {
            rst[count++] = heap.poll();
        }
        return rst;
    }
};

