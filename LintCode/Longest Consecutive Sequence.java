public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || V == null || A.length == 0 || V.length == 0){
            return 0;
        }
        int[] f = new int[m + 1];
        for (int i = 0; i < m; i++) f[i] = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= A[i]; j--) {
                if (f[j] < f[j - A[i]] + V[i]) {
                    f[j] = f[j - A[i]] + V[i];
                }
            }
        }
        return f[m];
    }
}
//思路，向前，向下减一看有没有在set里面。空间换时间。