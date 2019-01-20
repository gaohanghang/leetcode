package a0算法面试题.八大排序算法.a0_排序算法模板;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/18 21:37
 */
public class Example {
    public static void sort(int[] a) {
        /* 请见算法2.1、算法2.2、算法2.3、算法2.4、算法2.5、算法2.6或算法2.7*/
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
        // 从标准输入读取字符串，将它们排序并输出
        int[] a = {5, 6, 9, 1, 2, 3};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
