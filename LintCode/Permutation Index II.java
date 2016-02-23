public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        if (A == null || A.length == 0) {
            return 0L;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        long mutifact = 1;
        long fact = 1;
        long result = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
                mutifact = mutifact * map.get(A[i]);
            } else {
                map.put(A[i], 1);
            }
            long rank = 0;
            
            for (int j = i + 1; j < A.length; j++) {
                if(A[j] < A[i]) rank++;
            }
            
            result += fact * rank / mutifact;
            fact = fact * (A.length - i);
            }
        return result;
    }
}


// 题 Permutation Index 的扩展，这里需要考虑重复元素，有无重复元素最大的区别在于原来的1!, 2!, 3!...等需要除以重复元素个数的阶乘，颇有点高中排列组合题的味道。记录重复元素个数同样需要动态更新，引入哈希表这个万能的工具较为方便。
// http://algorithm.yuanbin.me/zh-hans/exhaustive_search/permutation_index_ii.html