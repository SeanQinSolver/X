public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<Integer>(nums);
        if (nums == null || nums.size() == 0) return result;
        
        int k = -1;
        for (int i = result.size() - 2; i >= 0; i--) {
            if (result.get(i) > result.get(i + 1)) {
                k = i;
                break;
            }
        }
        
        if (k == -1) {
            reverse(result, 0, result.size() - 1);
            return result;
        }
        
        int l = result.size() - 1;
        while (l > k && result.get(l) >= result.get(k)) {
            l--;
        }
        
        swap(result, k, l);
        
        reverse(result, k + 1, result.size() - 1);
        return result;
    }
    
    private void reverse(ArrayList<Integer> num, int lb, int ub) {
        for (int i = lb, j = ub;  i < j; i++, j--) {
            swap(num, i, j);
        }
    }
    
    private void swap(ArrayList<Integer> num, int lb, int ub) {
        int temp = num.get(lb);
        num.set(lb, num.get(ub));
        num.set(ub, temp);
    }
}

//也可用Collections.swap(num, i, j）

// 从后往前寻找索引满足 a[k] > a[k + 1], 如果此条件不满足，则说明已遍历到最后一个。
// 从后往前遍历，找到第一个比a[k]小的数a[l], 即a[k] > a[l].
// 交换a[k]与a[l].
// 反转k + 1 ~ n之间的元素。
