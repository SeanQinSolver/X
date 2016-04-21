public class Solution {
    /**
     * @param A: an array of integers
     * @return: an integer
     */
    
    //思路:将各自数字对应的值和INDEX对应放在一起
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        
        for (int i = 0; i < len; i++) {
            while (A[i] != i + 1) {
                
                if (A[i] <= 0 || A[i] >= len) break;
                
                //相邻两个数
                if(A[i] == A[A[i]-1]) break;
                
                //swap the elements
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}


////容易想到的方案是先排序，然後遍歷求得缺的最小整數。排序算法中常用的基於比較的方法時間複雜度的理論下界為 O(n \log n)O(nlogn), 不符題目要求。常見的能達到線性時間複雜度的排序算法有 基數排序，計數排序 和 桶排序。
//基數排序顯然不太適合這道題，計數排序對元素落在一定區間且重複值較多的情況十分有效，且需要額外的 O(n)O(n) 空間，對這道題不太合適。最後就只剩下桶排序了，桶排序通常需要按照一定規則將值放入桶中，一般需要額外的 O(n)O(n) 空間，乍看之下似乎不太適合在這道題中使用，但是若能設定一定的規則原地交換原數組的值呢？這道題的難點就在於這種規則的設定。
//設想我們對給定數組使用桶排序的思想排序，第一個桶放1，第二個桶放2，如果找不到相應的數，則相應的桶的值不變(可能為負值，也可能為其他值)。
//那麼怎麼才能做到原地排序呢？即若 A[i] = xA[i]=x, 則將 x 放到它該去的地方 - A[x - 1] = xA[x−1]=x, 同時將原來 A[x - 1]A[x−1] 地方的值交換給 A[i]A[i].
//排好序後遍歷桶，如果不滿足 f[i] = i + 1f[i]=i+1, 那麼警察叔叔就是它了！如果都滿足條件怎麼辦？那就返回給定數組大小再加1唄。


//写法2

public class Solution {
    /**
     * @param A: an array of integers
     * @return: an integer
     */
    
    //思路:将各自数字对应的值和INDEX对应放在一起
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            while (A[i] > 0 && A[i] < len && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}


//将桶假象成大小和array的length一样的。若array的某个值超出size则不考虑他