public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i : num) {
            hs.add(i);
        }
        Arrays.sort(num);
        int lcs = 0;
        for (int n : num) {
            int i = n, count = 1;
            hs.remove(n);
            while (hs.contains(++i)) {
                count++;
                hs.remove(i);
            }
            i = n;
            while (hs.contains(--i)) {
                count++;
                hs.remove(i);
            }
            lcs = Math.max(lcs, count);
        }
        return lcs;
    }
    
}
//思路，向前，向下减一看有没有在set里面。空间换时间。