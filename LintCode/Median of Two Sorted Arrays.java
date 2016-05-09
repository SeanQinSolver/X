//solution1, mergesort, O(m + n)
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) return -1.0;
        
        
        int len1 = (nums1 == null) ? 0 : nums1.length;
        int len2 = (nums2 == null) ? 0 : nums2.length;
        int len = len1 + len2;
        
        int[] array = new int[len];
        
        int count1 = 0;
        int count2 = 0;
        int index = 0;
        while (count1 < len1 && count2 < len2) {
            if (nums1[count1] < nums2[count2]) {
                array[index] = nums1[count1++];
            } else {
                array[index] = nums2[count2++];
            }
            index++;
        }
        while (count1 < len1) {
            array[index++] = nums1[count1++];
        }
        while (count2 < len2) {
            array[index++] = nums2[count2++];
        }
        
        if (len % 2 == 0) {
            return (array[len / 2 - 1] + array[len / 2]) / 2.0;
        } else {
            return array[len / 2];
        }
    }
}


//solution2 merge with space optimization

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) return -1.0;
        
        
        int len1 = (nums1 == null) ? 0 : nums1.length;
        int len2 = (nums2 == null) ? 0 : nums2.length;
        int len = len1 + len2;
        
        //int[] array = new int[len];
        
        int count1 = 0;
        int count2 = 0;
        int index = 0;
        
        int indexM1 = (len - 1) / 2;
        int indexM2 = len / 2;
        
        int m1 = 0;
        int m2 = 0;
        
        while (count1 < len1 && count2 < len2) {
            if (index > indexM2)  break;
            if (index == indexM1) {
                m1 = Math.min(nums1[count1], nums2[count2]);
            }
            if (index == indexM2) {
                m2 = Math.min(nums1[count1], nums2[count2]);
            }
            if (nums1[count1] < nums2[count2]) {
                count1++;
            } else {
                count2++;
            }
            index++;
        }
        while (count1 < len1) {
            if (index > indexM2) break;
            if (index == indexM1) m1 = nums1[count1];
            if (index == indexM2) m2 = nums1[count1];
            index++;
            count1++;
        }
        while (count2 < len2) {
            if (index > indexM2) break;
            if (index == indexM1) m1 = nums2[count2];
            if (index == indexM2) m2 = nums2[count2];
            index++;
            count2++;
        }
        
        if (len % 2 == 0) {
            return (m1 + m2) / 2.0;
        } else {
            return m2;
        }
    }
}

//method3

public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) return -1.0;
        
        int lenA = (A == null) ? 0 : A.length;
        int lenB = (B == null) ? 0 : B.length;
        
        int len = lenA + lenB;
        
        //偶数个数的话median是中间两数计算
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            //奇数个数的话median就是中间一个数
            return findKth(A, 0, B, 0, len / 2);
        }
    }
    
    private double findKth(int[] A, int indexA, int[] B, int indexB, int k) {
        int lenA = (A == null) ? 0 : A.length;
        //若A超过边界，则取B的从index开始第k个
        if (indexA > lenA - 1) {
            return B[indexB + k - 1];
        }
        int lenB = (B == null) ? 0 : B.length;
        if (indexB > lenB - 1) {
            return A[indexA + k - 1];
        }
        
        //循环退出条件
        if (k == 1) return Math.min(A[indexA], B[indexB]);
        
        int keyA = Integer.MAX_VALUE;
        int keyB = Integer.MAX_VALUE;
        
        //判断若indexA在边界里
        if (indexA + k / 2 - 1 < lenA) keyA = A[indexA + k / 2 - 1];
        //判断若indexB在边界里
        if (indexB + k / 2 - 1 < lenB) keyB = B[indexB + k / 2 - 1];
        
        if (keyA > keyB) {
            //取小的在k / 2处继续
            //已经判断了前k/2个，所以再判断k - k / 2个
            return findKth(A, indexA, B, indexB + k / 2, k - k / 2);
        } else {
            return findKth(A, indexA + k / 2, B, indexB, k - k / 2);
        }
    }
}


题中已有信息两个数组均为有序，找中位数的关键在于找到第一半大的数，显然可以使用二分搜索优化。本题是找中位数，其实可以泛化为一般的找第 k 大数，这个辅助方法的实现非常有意义！在两个数组中找第k大数->找中位数即为找第k大数的一个特殊情况——第(A.length + B.length) / 2 大数。因此首先需要解决找第k大数的问题。这个联想确实有点牵强...+

由于是找第k大数(从1开始)，使用二分法则需要比较A[k/2 - 1]和B[k/2 - 1]，并思考这两个元素和第k大元素的关系。
A[k/2 - 1] <= B[k/2 - 1] => A和B合并后的第k大数中必包含A[0]~A[k/2 -1]，可使用归并的思想去理解。
若k/2 - 1超出A的长度，则必取B[0]~B[k/2 - 1]


本题用非递归的方法非常麻烦，递归的方法减少了很多边界的判断。此题的边界条件较多，不容易直接从代码看清思路。首先分析找k大的辅助程序。以 Java 的代码为例。
首先在主程序中排除 A, B 均为空的情况。
排除 A 或者 B 中有一个为空或者长度为0的情况。如果A_start > A.size() - 1，意味着A中无数提供，故仅能从B中取，所以只能是B从B_start开始的第k个数。下面的B...分析方法类似。
k为1时，无需再递归调用，直接返回较小值。如果 k 为1不返回将导致后面的无限循环。
以A为例，取出自A_start开始的第k / 2个数，若下标A_start + k / 2 - 1 < A.size()，则可取此下标对应的元素，否则置为int的最大值，便于后面进行比较，免去了诸多边界条件的判断。
比较A_key > B_key，取小的折半递归调用findKth。
接下来分析findMedianSortedArrays：
首先考虑异常情况，A, B都为空。
A+B 的长度为偶数时返回len / 2和 len / 2 + 1的均值，为奇数时则返回len / 2 + 1