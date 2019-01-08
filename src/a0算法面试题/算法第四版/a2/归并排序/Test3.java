package a0算法面试题.算法第四版.a2.归并排序;

import java.util.Arrays;

/**
 * @Description: 自底向上的归并排序
 * @author: Gao Hang Hang
 * @date 2019/01/05 21:31
 */
public class Test3 {
    public static void main(String[] args) {
        new Test3().sort(new int[]{1,3,9,8,3,2,1});
    }

    private int[] aux;      // 归并所需的辅助数组

    public void sort(int[] a) {
        // 进行lgN次两两归并
        int N = a.length;
        aux = new int[N];
        for (int sz = 1; sz < N; sz = sz + sz)      // sz子数组大小
            for (int lo = 0; lo < N-sz; lo += sz+sz) // lo:子数组索引
                merge(a, lo, lo+sz -1, Math.min(lo+sz+sz-1, N-1));
        System.out.println(Arrays.toString(a));
    }

    public void merge(int[] a, int lo,int mid, int hi) {
        // 将a[lo..mid] 和 a[mid+1..hi]归并
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) // 将a[lo..hi]复制aux[lo..hi]
            a[k] = aux[k];

        for (int k = lo; k <= hi; k++)
            if (i > mid)                    a[k] = aux[j++];  // 左半边用尽(取右半边的元素)
            else if (j > hi)                a[k] = aux[i++];  // 右半边用尽(取左半边的元素)
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];  // 右半边的当前元素小于左半边的当前元素（取右半边的元素）
            else                            a[k] = aux[i++];  // 右半边的当前元素大于等于左半边的当前元素（取左半边的元素）
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    private void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void show(int[] a) {
        // 在单行打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private boolean isSorted(int[] a) {
        // 测试数组是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
