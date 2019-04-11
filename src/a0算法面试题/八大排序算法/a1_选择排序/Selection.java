package a0算法面试题.八大排序算法.a1_选择排序;

import java.util.Arrays;

/**
 * 时间复杂度: O(n^second)
 * 空间复杂度: O(n^second)
 * 稳定性: 不稳定
 * 复杂性: 简单
 *
 * @Description: 选择排序
 * @author: Gao Hang Hang
 * @date 2019/01/18 19:38
 */
public class Selection {
    public static void sort(int[] a) {
        // 将a[]按升序排列
        int N = a.length;           // 数组长度
        for (int i = 0; i < N; i++) {
            // 将a[i]和a[i+1..N]中最小的元素交换
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
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
        // 在单行打印数组
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
        int[] nums = {6, 3, 5, 9, 1, 2};
        sort(nums);
        show(nums);
        System.out.println(isSorted(nums));
    }
}
