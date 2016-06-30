class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        } else if (x == 0) {
            return 0;
        }
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //double 64位 Math.pow(x, 2)
            if (Math.pow(mid, 2) == x) {
                return mid;
            } else if (Math.pow(mid, 2) < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}