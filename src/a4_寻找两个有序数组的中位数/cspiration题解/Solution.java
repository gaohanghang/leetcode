package a4_寻找两个有序数组的中位数.cspiration题解;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-09-05 21:30
 **/
class Solution {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * 有两个有序数组nums1和nums2 长度分别为m和n。
     * <p>
     * Find te median of the two sorted arrays. The overll run time complexity should be O(log (m+n)).
     * 找到两个排序数组的中位数。时间复杂度应为O(log(m+n))
     * <p>
     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]:
     * <p>
     * The median is 2.0
     * Example 2：
     * nums1 = [1, 2]
     * nums2 = [3,4]
     * <p>
     * The median is (2 + 3)/2 = 2.5
     * <p>
     * O(log(min(m,n)))
     * 参考博客: https://blog.csdn.net/chen_xinjia/article/details/69258706
     * <p>
     * index: 0   1   2   3   4   5
     * L1  R1
     * num1:  3   5 | 8   9               4  cut1：左有几个元素
     * num2:  1   2   7 | 10  11  12       6  cut2：左有几个元素
     * L2  R2
     * <p>
     * num3: 1 2 3 4 5 7 | 8 9 10 11 12
     * <p>
     * num3 -> num1 + num2 -> num1
     * <p>
     * L1 <= R2
     * L2 <= R1
     * <p>
     * L1 > R2 cut1 << (cutL, cut1 - 1)
     * L2 > R1 cut2 >> (cut1 + 1, cutR)
     * <p>
     * <p>
     * index: 0   1   2   3   4   5
     * L1  R1
     * num1:  3   5 | 8   9               4  cut1：左有几个元素
     * num2:  1   2   7 | 10  11  12       6  cut2：左有几个元素
     * L2  R2
     * <p>
     * int cut1 = 2;
     * int cut2 = 3;
     * int cutL = 0; nums1数组左侧范围
     * int cutR = 4; nums1数组右侧范围
     * <p>
     * time : O(log(min(m,n)))
     * space : O(1)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL; // (4- 0) / 2 + 0 = 2
            cut2 = len / 2 - cut1; // 2
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            // 当nums1数组不用切 R1为最大值
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            // 当nums2数组不用切 R2为最大值
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                // 左移
                cutR = cut1 - 1; // 2 - 1 = 1
            } else if (L2 > R1) {
                // 右移
                cutL = cut1 + 1;
            } else {
                // 长度为偶数
                if (len % 2 == 0) {
                    L1 = Math.max(L1, L2);
                    R1 = Math.min(R1, R2);
                    return (L1 + R1) / 2;
                } else {
                    // 最小
                    R1 = Math.min(R1, R2);
                    return R1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        double medianSortedArrays = new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(medianSortedArrays);
    }
}
