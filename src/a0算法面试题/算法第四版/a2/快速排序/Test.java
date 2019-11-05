package a0算法面试题.算法第四版.a2.快速排序;

import java.util.Arrays;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/05 17:18
 */
public class Test {
    public static void main(String[] args) {
        new Test().sort(new int[]{1,7,8,3,1,2});
    }

    public void sort(int[] a) {
        sort(a, 0, a.length -1);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);                  // 切分
        sort(a, lo, j-1);       // 将左半部分a[lo .. j-1]排序
        sort(a, j+1, hi);       // 将右半部分a[j+1 .. hi]排序
    }

    /*
        这段代码按照 a[lo] 的值 v 进行切分。当指针 i 和 j 相遇时主循环结束。
        a[i] 小于 v 时我们增大i, a[j] 大于v时我们减小 j,然后交换a[i]和 a[j] 来保证 i 左侧的元素都不大于v
        j 右侧的元素都不小于 v。当指针相遇时交换a[lo] 和 a[j], 切分结束（这样切分值就留在 a[j] 中）。
     */
    private int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo.. i-1], a[i], a[i+1..hi]
        int i = lo, j = hi + 1;     // 左右扫描指针
        int v = a[lo];              // 切分元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);      // 将 v = a[j]放入正确的位置
        return j;           // a[lo..j-1] <= a[j+1..hi] 达成
    }

    // 对元素进行比较
    private boolean less(int v, int w) {
        return v < w;
    }

    // 对元素进行交换
    private void exch (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
