public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int point1 = 0;
        int point2 = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while (point1 < nums1.length && point2 < nums2.length) {
            if (nums1[point1] < nums2[point2]) {
                point1++;
            } else if (nums1[point1] > nums2[point2]) {
                point2++;
            } else {
                list.add(nums1[point1]);
                point1++;
                point2++;
            }
        }
        int[] rst = new int[list.size()];
        int count = 0;
        while (count < rst.length) {
            rst[count] = list.get(count);
            count++;
        }
        return rst;
    }
}