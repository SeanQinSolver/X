public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                continue;
            }
            map.put(i, 1);
        }
        
        Comparator<Elem> comp = new Comparator<Elem>(){
            @Override
            public int compare(Elem o1, Elem o2) {
                return o1.freq - o2.freq;
            }
        };
        
        PriorityQueue<Elem> queue = new PriorityQueue<Elem>(k, comp);
        
        for (int i : map.keySet()) {
            Elem e = new Elem(i, map.get(i));
            if (queue.size() < k) queue.offer(e);
            else if (comp.compare(e, queue.peek()) > 0) {
                queue.poll();
                queue.offer(e);
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        while (!queue.isEmpty()) {
            result.add(queue.poll().value);
        }
        return result;
    }
    
    class Elem {
        int value;
        int freq;
        public Elem(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }
}