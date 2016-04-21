class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
       int ones = ~0;
       int mask = 0;
       if (j < 31) {
           //或用这种方法mask = ~((1 << (j + 1)) - (1 << i));
           int left = ones << (j + 1);
           int right = ((1 << i) - 1);
           mask = left | right;
       } else {
           //如果大于31的话，只管起始的i
           mask = (1 << i) - 1;
       }
       return (mask & n) | (m << i); 
    }
}
