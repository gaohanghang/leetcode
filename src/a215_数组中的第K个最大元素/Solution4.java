package a215_数组中的第K个最大元素;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/24 18:40
 */
public class Solution4 {
    int[] nums;

    public void swap(int a, int b) {

    }

    // 快速排序的切分
    private static int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi + 1;         // 左右扫描指针
        int v = a[lo];                  // 切分元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[j--])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);         // 将v = a[j]放入正确的位置
        return j;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void show(int[] a) {
        // 在单行打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
