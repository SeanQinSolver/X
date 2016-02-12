//method1 
public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            list.add((i >> 1) ^ i);
        }
        return list;
    }
}

//method2 2n 

public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (n < 0) {
            return list;
        }
        if (n == 0) {
            list.add(0);
            return list;
        }
        list.add(0);
        list.add(1);
        
        for (int i = 2; i <= n; i++) {
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
                // list.get(i) 反向获得数组的值，然后加上10， 100， 1000（就是加上1）
                list.add(list.get(j) + (1 << (i - 1)));
            }
        }
        return list;
    }
}