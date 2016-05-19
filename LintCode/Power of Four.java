public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        if (n < 4) return false;
        
        int count = 0;
        int copy_n = n;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 0) count++;
            if ((n & 1) != 0) break;
            n >>= 1;
        }
        //System.out.println(count);
        return ((1 << count) == copy_n) && (count % 2 == 0);
    }
}