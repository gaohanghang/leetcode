package a0算法面试题.八大排序算法.a3_希尔排序;

import java.util.logging.Level;

/**
 * 时间复杂度: O(n^1.3)
 * 空间复杂度: O(1)
 * 稳定性: 不稳定
 * 复杂性: 较复杂
 *
 * 思想: 先部分排序，再插入排序
 *
 * @Description: 希尔排序
 * @author: Gao Hang Hang
 * @date 2019/01/18 21:44
 */
public class Shell {
    public static void sort(int[] a) {
        // 将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < N; i++) {
                // 将a[i] 插入到a[i-h], a[i-second*h], a[i-3*h]... 之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(int[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private static boolean isSorted(int[] a) {
        // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 9, 1, 2, 3, 19};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
