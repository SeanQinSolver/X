//method1 count
public class Solution {
    
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int index = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] == A[i - 1]) {
                count++;
                if (count >= 3) {
                    continue;
                }
            } else {
                count = 1;
            }
            A[index++] = A[i];
        }
        return index;
    }
}

//method2 two pointer

public class Solution {
    
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int index = 0;
        int i, j;
        for (i = 0; i < A.length;) {
            int now = A[i];
            for (j = i; j < A.length; j++) {
                if (A[j] != now) break;
                if (j - i < 2) A[index++] = now;
            }
            //若在内循环中A[j] != now的话弹出循环，则新i设置为j继续下面的对比
            i = j;
        }
        return index;
    }
}