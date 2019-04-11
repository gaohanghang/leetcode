package a692_前k个高频单词.TOPK问题解决思路;


public class Solution2 {


    //public int findKthLargest(int[] nums, int k) {
    //    int l = 0;
    //    int r = nums.length - 1;
    //    int left = k
    //}
    //
    //private int partition(int[] a, int lo, int hi) {
    //    // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
    //    int i = lo, j = hi + 1;     // 左右扫描指针
    //    int v = a[lo];              // 切分元素
    //    while (true) {
    //        // 扫描左右，检查扫描是否结束并交换元素
    //        while ()
    //    }
    //
    //}

    private static int partition(int[] a, int lo, int hi) {
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
}
