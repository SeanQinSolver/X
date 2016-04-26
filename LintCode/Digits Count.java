//method1

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int count = 0;
        for (int i = k; i <= n; i++) {
            char[] array = String.valueOf(i).toCharArray();
            for (char c : array) {
                if (c == ((char)(k + '0'))) count++;
            }
        }
        return count;
    }
};


//method2

