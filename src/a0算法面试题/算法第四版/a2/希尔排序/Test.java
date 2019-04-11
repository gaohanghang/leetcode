package a0算法面试题.算法第四版.a2.希尔排序;

import java.util.Arrays;

/**
 * 算法第四版
 * 希尔排序的思想是使数组中任意间隔为 h 的元素都是有序的。这样的数组被称为 h 有序数组。换句话说就是
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/05 14:38
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.merge(new int[]{2,0}, 1,new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++)
            nums1[m+i] = nums2[i];

        // 希尔排序
        int N = m + n;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093 递增序列
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h], a[i-second*h], a[i-3*h]... 之中
                for (int j = i; j >= h; j -= h) {
                    if (nums1[j] < nums1[j-h]) {
                        int temp = nums1[j];
                        nums1[j] = nums1[j-h];
                        nums1[j-h] = temp;
                    }
                }
            }
            h = h / 3;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
