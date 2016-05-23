public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        int x1orx2 = 0;
        for (int i : A) {
            x1orx2 ^= i;
        }
        
        //last 1 bit
        int lastBit = x1orx2 - (x1orx2 & (x1orx2 - 1));
        int single1 = 0;
        int single2 = 0;
        
        for (int i : A) {
            if ((lastBit & i) == 0) single1 ^= i;
            else single2 ^= i;
        }
        List<Integer> rst = new ArrayList<Integer>();
        rst.add(single1);
        rst.add(single2);
        return rst;
    }
}