package a0算法面试题.算法第四版.a2.快速排序;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @author: Gao Hang Hang
 * @date 2019/01/05 18:13
 */
public class Test2 {
    public static void main(String[] args) {
        new Test2().sort(new int[]{1,9,8,7,1,2,3});
    }

    public void sort(int[] a) {
        sort(a, 0, a.length -1);
        System.out.println(Arrays.toString(a));
    }

    private void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j -1);
        sort(a, j+1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo.. i-1], a[i], a[i+1..hi]
        int i = lo, j = hi+1;       // 左右扫描指针
        int v = a[lo];              // 切分元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);         // 将v = a[j] 放入正确的位置
        return j;               // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
    }

    // 对元素进行比较
    private boolean less(int v, int w) {
        return v < w;
    }

    // 将元素交换位置
    private void exch (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
