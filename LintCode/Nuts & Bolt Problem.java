/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null) return;
        if (nuts.length != bolts.length) return;
        
        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }
    private void qsort(String[] nuts, String[] bolts, NBComparator compare, int l, int u) {
        if (l >= u) return;
        //find the partition index for nuts with bolts
        int part_inx = partition(nuts, bolts[l], compare, l, u);
        //partition bolts with nuts[part_inx]
        partition(bolts, nuts[part_inx], compare, l , u);
        //qsort recursively
        qsort(nuts, bolts, compare, l, part_inx - 1);
        qsort(nuts, bolts, compare, part_inx + 1, u);
    }
    
    private int partition(String[] str, String pivot, NBComparator compare, int l, int u) {
        int m = l;
        for (int i = l + 1; i <= u; i++) {
            if (compare.cmp(str[i], pivot) == -1 || compare.s(pivot, str[i]) == 1) {
                m++;
                swap(str, i, m);
            } else if (compare.cmp(str[i], pivot) == 0 || compare.cmp(pivot, str[i]) == 0) {
                swap(str, i, l);
                i--;
            }
        }
        swap(str, m, l);
        return m;
    }
    private void swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
};

//难以理解的可能在partition部分，不仅需要使用compare.cmp(alist[i], pivot), 同时也需要使用compare.cmp(pivot, alist[i]), 否则答案有误。第二个在于alist[i] == pivot时，需要首先将其和alist[l]交换，因为i是从l+1开始处理的，将alist[l]换过来后可继续和 pivot 进行比较。在 while 循环退出后在将当前遍历到的小于 pivot 的元素 alist[m] 和 alist[l] 交换，此时基准元素正确归位。对这一块不是很清楚的举个例子就明白了。