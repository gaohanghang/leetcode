package a0算法面试题.八大排序算法.a2_插入排序;

/**
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(n^2)
 * 稳定性: 稳定
 * 复杂性: 简单
 *
 * @Description: a2_插入排序
 * @author: Gao Hang Hang
 * @date 2019/01/02 12:04
 */
public class InsertSort {
    public static void sort(int[] a) {
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // 将 a[i] 插入到 a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
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
        int[] a = {5, 6, 9, 1, 2, 3};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
