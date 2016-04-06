class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int result = 0;
        int count = k;
        //注意循环应从count开始
        while (count <= n) {
            char[] c = String.valueOf(count).toCharArray();
            for (char c1 : c) {
                if ((c1 - '0') == k) {
                    result++;
                }
            }
            count++;
        }
        return result;
    }
};


//solution2

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int result = 0;
        char chark = (char)(k + '0');
        //注意此循环应从k开始
        for (int i = k; i <= n; i++) {
            char[] array = Integer.toString(i).toCharArray();
            for (char char1 : array) {
                if (char1 == chark) {
                    result++;
                }
            }
        }
        return result;
    }
};
