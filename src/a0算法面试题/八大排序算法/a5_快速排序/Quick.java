package a0算法面试题.八大排序算法.a5_快速排序;

import java.rmi.dgc.Lease;

/**
 * @Description: 快速排序
 * @author: Gao Hang Hang
 * @date 2019/01/19 22:43
 */
public class Quick {
    public static void sort(int[] a) {
        sort(a, 0, a.length -1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = prrtion(a, lo, hi);   // 切分
        sort(a, lo, j -1);        // 将左半边部分a[lo .. j-1]排序
        sort(a, j+1, hi);         // 将右半部分a[j+1 .. hi]排序
    }

    private static int prrtion(int[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi + 1; // 左右扫描指针
        int v = a[lo];          // 切分元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);         // 将v = a[j]放入正确的位置
        return j;               // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
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
        int[] a = {5, 6, 9, 1, 2, 3};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
