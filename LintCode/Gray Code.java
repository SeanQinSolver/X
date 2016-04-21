//method1
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        
        ArrayList<Integer> temp = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        for (int i = temp.size() - 1; i >= 0; i--) {
            temp.add(temp.get(i) + addNumber);
        }
        return temp;
    }
}


//method2


