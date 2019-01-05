package a0算法面试题.算法第四版.a2.归并排序;

import java.util.Arrays;

/**
 * @Description: 算法第四版 归并排序
 * @author: Gao Hang Hang
 * @date 2019/01/04 14:36
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.merge(new int[]{4,5,6,0,0,0}, 3,new int[]{1,2,3}, 3);
    }

    private int[] aux; // 归并所需的辅助数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++)
            nums1[m+i] = nums2[i];

        // 归并排序
        aux = new int[m+n];
        sort(nums1, 0, m+n-1);
    }

    public void sort(int[] a, int lo, int hi) {
        // 将数组a[lo..hi]排序
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);     // 将左半边排序
        sort(a, mid+1, hi);   // 将右半边排序
        merge(a, lo, mid, hi);
    }

    public void merge(int[] a, int lo, int mid, int hi) {
        // 将a[lo..mid] 和 a[mid..hi] 归并
        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++)   // 将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)   // 归并回到a[lo..hi]复制到aux[lo..hi]
            if  (i > mid)               a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (aux[j] < aux[i])   a[k] = aux[j++];
            else                        a[k] = aux[i++];
        System.out.println(Arrays.toString(a));
    }
}
