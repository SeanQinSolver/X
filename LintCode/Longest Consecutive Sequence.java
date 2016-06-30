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
        //可以不要arrays.sort
        //Arrays.sort(num);
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
//思路，向前，向后减一看有没有在set里面。空间换时间。
//有点manacher algorithm的样子

//method2, 不要arrays.sort(num）

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }
        //Arrays.sort(num);
        int lcs = 0;
        for (int n : num) {
            int i = n, count = 1;
            set.remove(n);
            
            while (set.contains(++i)) {
                set.remove(i);
                count++;
            }
            i = n;
            while (set.contains(--i)) {
                set.remove(i);
                count++;
            }
            lcs = Math.max(lcs, count);
        }
        return lcs;
    }
}

//思路，向前，向下减一看有没有在set里面。空间换时间。