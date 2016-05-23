//method1
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            int hmax = Math.min(citations[i], citations.length - i);
            result = Math.max(hmax, result);
        }
        return h;
    }
}

//method1 写法2
方法一：

O(nlogn)时间，O(1)空间。
现将数组排序。然后从大到小遍历，一边计数一边比较计数与当前的引用数，直到计数大于引用数。
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int hIdx = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > hIdx) hIdx++;
            else break;
        }
        return hIdx;
    }
}

//method2

O(n)时间，O(n)空间。
使用一个额外的数组，其下标为引用数，置为为具有该引用数的文章数量。
注意，根据定义，H-index的上限不可能超过文章总数n。因此我们只需要额外开一个长度为n的数组即可。
然后对新数组按引用数从大到小遍历，一边计数一边比较计数与当前的引用数，直到计数大于引用数。

public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (citations == null || len == 0) return 0;
        int[] counts = new int[len + 1];
        
        for (int c : citations) {
            if (c > len) {
                counts[len]++;
            } else {
                counts[c]++;
            }
        }
        
        if (counts[len] >= len) return len;
        for (int i = len - 1; i >= 0; i--) {
            counts[i] += counts[i + 1];
            if (counts[i] >= i) return i;
        }
        return 0;
    }
}