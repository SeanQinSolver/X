class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int i = A.length - 1;
        int j = B.length - 1;
        int newLen = i + j + 2;
        int index = i + j + 1;
        int[] new1 = new int[newLen];
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                new1[index--] = A[i--];
            } else {
                new1[index--] = B[j--];
            }
        }
        while (i >= 0) {
            new1[index--] = A[i--];
        }
        while (j >= 0) {
            new1[index--] = B[j--];
        }
        return new1;
    }
}


//method2

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int m = A.length - 1;
        int n = B.length - 1;
        int newLen = m + n + 2;
        int[] newArray = new int[newLen];
        
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        
        while (p1 <= m && p2 <= n) {
            if (A[p1] > B[p2]) {
                newArray[p3++] = B[p2++];
            } else {
                newArray[p3++] = A[p1++];
            }
        }
        
        while (p1 <= m) {
            newArray[p3++] = A[p1++];
        }
        while (p2 <= n) {
            newArray[p3++] = B[p2++];
        }
        return newArray;
    }
}