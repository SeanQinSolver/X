public class Solution {
    /**
     * @param A : An integer array
     * @return : An integer
     */
    public int singleNumberII(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                count += ((A[j] >> i) & 1);
            }
            result |= ((count % 3) << i);
        }
        return result;
    }
}

//扩展题http://algorithm.yuanbin.me/zh-hans/math_and_bit_manipulation/single_number_ii.html