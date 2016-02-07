public class Solution {
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int sum = A[0];
        int max = sum;
        int start = 0, end = 0;
        result.add(0);
        result.add(0);
        for (int i = 1; i < A.length; i++) {
            if (sum > max) {
                result.set(0, start);
                result.set(1, i - 1);
                max = sum;
            }
            //sum为零回复到
            if (sum < 0) {
                sum = 0;
                start = i;
                end = i;
            }
            sum += A[i];
        }
        if (sum > max) {
            result.set(0, start);
            result.set(1, A.length - 1);
        }
        return result;
    }
}