public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m > n) return 0;
        
        int index = 0;
        while (m != n && m != 0) {
            m >>= 1;
            n >>= 1;
            index++;
        }
        return m << index;
    }
}