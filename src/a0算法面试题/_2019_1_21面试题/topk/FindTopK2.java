package a0算法面试题._2019_1_21面试题.topk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/23 16:14
 */
public class FindTopK2 {

    /*
        虽然我们不会采用快速排序的算法来实现TOP-K问题，但我们可以利用快速排序的思想，在数组中随机找一个元素key，将数组分成两部分Sa和Sb，其中Sa的元素>=key，Sb的元素<key，然后分析两种情况：

        * 若Sa中元素的个数大于或等于k，则在Sa中查找最大的k个数
        * 若Sa中元素的个数小于k，其个数为len，则在Sb中查找k-len个数字

        如此递归下去，不断把问题分解为更小的问题，直到求出结果。

        该算法的平均时间复杂度为O(N * logk)。以求K大的数为例，算法实现如下：
     */

    public static int findTopK(int[] a, int lo, int hi, int k) {
        int index = -1;
        if (lo < hi) {  // 如果lo < hi直接返回-1
            int j = partition(a, lo, hi);
            int len = j - lo + 1;  // 12345 01234
            if (len == k) {
                index = j;
            } else if (len < k) {  // Sa中元素个数小于K, 到
                index = findTopK(a,j + 1, hi, k);
            } else { // Sa中元素的个数大于或等于k
                index = findTopK(a, lo, hi -1, k);
            }
        }
        return index;
    }

    /**
     * 按切分元素划分数组，左边的元素大于切分元素，右边的元素小于切分元素
     */
    public static int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi + 1;     // 左右扫描指针
        int v = a[lo];              // 切分元素
        while (true) {
            // 扫描左右，检查是否结束并交换元素
            while (less(v, a[++i])) if (i == hi) break;  // 从左边找到比v 大元素
            while (less(a[--j], v)) if (j == lo) break;  // 从右边找到比v 小的元素
            if (i > j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);     // 将v = a[j]放入正确的位置
        return j;
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
            System.out.println(a[i] + " ");
    }

    public static void main(String[] args) {
        int k = 4;
        int[] a = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26};
        findTopK(a, 0, a.length - 1, k);
        System.out.println("array top k:{" + Arrays.stream(a).mapToObj(value -> String.valueOf(value)).limit(k).collect(Collectors.joining(",")) + "}");
    }
}
